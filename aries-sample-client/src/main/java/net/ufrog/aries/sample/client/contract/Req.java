package net.ufrog.aries.sample.client.contract;

import java.io.Serializable;

/**
 * 请求
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
public class Req implements Serializable {

    private static final long serialVersionUID = -2797289509428414751L;

    /** 请求头 */
    private ReqHeader header;

    /** 构造函数 */
    public Req() {
        this.header = new ReqHeader();
    }

    /**
     * 读取请求头
     *
     * @return 请求头
     */
    public ReqHeader getHeader() {
        return header;
    }

    /**
     * 设置请求头
     *
     * @param header 请求头
     */
    public void setHeader(ReqHeader header) {
        this.header = header;
    }

    /**
     * 请求头
     *
     * @author ultrafrog, ufrog.net@gmail.com
     * @version 0.1, 2018-02-21
     * @since 0.1
     */
    public static class ReqHeader {

    }
}
