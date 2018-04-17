package net.ufrog.aries.common.contract;

import net.ufrog.common.app.App;
import net.ufrog.common.dict.Dicts;
import net.ufrog.common.exception.ServiceException;
import net.ufrog.common.utils.Strings;

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

    private static final String CONF_CLIENT_RESULT_CODE_CLASS   = "client.resultCodeClass";
    private static final String CONF_CLIENT_SUCCESS_CODE        = "client.successCode";
    private static final String DEFAULT_SUCCESS_CODE            = "0000";

    private static Class<?> resultCodeClass;
    private static String successCode;

    /** 结果代码 */
    private String resultCode;

    /** 结果消息 */
    private String message;

    /** 是否成功 */
    private Boolean success;

    /** 构造函数 */
    public Resp() {}

    /**
     * 构造函数
     *
     * @param resultCode 结果代码
     */
    public Resp(String resultCode) {
        this();
        this.resultCode = resultCode;
    }

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
        if (Strings.empty(message)) {
            return Dicts.name(resultCode, getResultCodeClass());
        }
        return message;
    }

    /**
     * 设置消息
     *
     * @param message 消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 判断是否成功
     *
     * @return 判断结果
     */
    public Boolean isSuccess() {
        if (success == null) {
            return (Strings.empty(resultCode) || Strings.equals(getSuccessCode(), resultCode));
        }
        return success;
    }

    /**
     * 设置是否成功
     *
     * @param success 是否成功
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * 读取结果代码字典类
     *
     * @return 结果代码字典类
     */
    private static Class<?> getResultCodeClass() {
        if (resultCodeClass == null) {
            String className = App.config(CONF_CLIENT_RESULT_CODE_CLASS);
            try {
                resultCodeClass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new ServiceException("cannot find result code class: " + className, e);
            }
        }
        return resultCodeClass;
    }

    /**
     * 读取成功代码
     *
     * @return 成功代码
     */
    private static String getSuccessCode() {
        if (successCode == null) {
            successCode = App.config(CONF_CLIENT_SUCCESS_CODE, DEFAULT_SUCCESS_CODE);
        }
        return successCode;
    }
}
