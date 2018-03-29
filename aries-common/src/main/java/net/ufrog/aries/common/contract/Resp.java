package net.ufrog.aries.common.contract;

import net.ufrog.common.app.App;
import net.ufrog.common.dict.Dicts;
import net.ufrog.common.utils.Strings;
import org.hibernate.service.spi.ServiceException;

import java.io.Serializable;

/**
 * 基础响应
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-03-27
 * @since 0.1
 */
public class Resp implements Serializable {

    private static final long serialVersionUID = -923205047842987950L;

    private static final Class<?> RESULT_CODE_CLASS;
    private static final String SUCCESS_CODE;

    static {
        String className = App.config("client.resultCodeClass");
        try {
            RESULT_CODE_CLASS = Class.forName(className);
            SUCCESS_CODE = App.config("client.successCode", "0000");
        } catch (ClassNotFoundException e) {
            throw new ServiceException("cannot find result code class: " + className, e);
        }
    }

    /** 结果代码 */
    private String resultCode;

    /**
     * 读取结果代码
     *
     * @return 结果代码
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 设置结果代码
     *
     * @param resultCode 结果代码
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 读取消息
     *
     * @return 消息内容
     */
    public String getMessage() {
        return Dicts.name(resultCode, RESULT_CODE_CLASS);
    }

    /**
     * 判断是否成功
     *
     * @return 判断结果
     */
    public Boolean isSuccess() {
        return (Strings.empty(resultCode) || Strings.equals(SUCCESS_CODE, resultCode));
    }
}
