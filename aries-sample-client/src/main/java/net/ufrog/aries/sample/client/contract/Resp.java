package net.ufrog.aries.sample.client.contract;

import net.ufrog.common.dict.Dicts;
import net.ufrog.common.dict.Element;
import net.ufrog.common.utils.Strings;

import java.io.Serializable;

/**
 * 响应
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
public class Resp implements Serializable {

    private static final long serialVersionUID = -922112126002045340L;

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
     * 响应是否成功
     *
     * @return 判断结果
     */
    public Boolean isSuccess() {
        return Strings.empty(this.resultCode) || Strings.equals(ResultCode.SUCCESS, this.resultCode);
    }

    /**
     * 读取结果消息
     *
     * @return 结果消息
     */
    public String getResultMessage() {
        return Dicts.name(this.resultCode, ResultCode.class);
    }

    /**
     * 结果代码
     *
     * @author ultrafrog
     * @version 0.1, 2018-02-21
     * @since 0.1
     */
    public static final class ResultCode {

        @Element("成功")
        public static final String SUCCESS  = "0000";

        @Element("未知异常")
        public static final String UNKNOW    = "9999";
    }
}
