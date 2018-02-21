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

    /** 代码 */
    private String code;

    /**
     * 响应是否成功
     *
     * @return 判断结果
     */
    public Boolean isSuccess() {
        return Strings.empty(this.code) || Strings.equals(Code.SUCCESS, this.code);
    }

    /**
     * 读取消息
     *
     * @return 消息内容
     */
    public String getMessage() {
        return Dicts.name(this.code, Code.class);
    }

    /**
     * 代码
     *
     * @author ultrafrog
     * @version 0.1, 2018-02-21
     * @since 0.1
     */
    public static final class Code {

        @Element("成功")
        public static final String SUCCESS  = "0000";

        @Element("未知异常")
        public static final String UNKNOW    = "9999";
    }
}
