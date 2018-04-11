package net.ufrog.aries.common.exception;

import net.ufrog.common.exception.ServiceException;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-04-11
 * @since 3.0.0
 */
public class AriesException extends ServiceException {

    private static final long serialVersionUID = -8505173822228948319L;

    /** 结果代码 */
    private String resultCode;

    /** 构造函数 */
    private AriesException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param resultCode 结果代码
     */
    private AriesException(String resultCode) {
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
}
