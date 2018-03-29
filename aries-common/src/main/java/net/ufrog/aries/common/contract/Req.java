package net.ufrog.aries.common.contract;

import java.io.Serializable;

/**
 * 基础请求
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-03-27
 * @since 0.1
 */
public class Req implements Serializable {

    private static final long serialVersionUID = 1755816194688390660L;

    /** 请求头 */
    private ReqHeader reqHeader;

    /** 构造函数 */
    public Req() {
        this.reqHeader = new ReqHeader();
    }

    /**
     * 读取请求头
     *
     * @return 请求头
     */
    public ReqHeader getReqHeader() {
        return reqHeader;
    }

    /**
     * 设置请求头
     *
     * @param reqHeader 请求头
     */
    public void setReqHeader(ReqHeader reqHeader) {
        this.reqHeader = reqHeader;
    }

    /**
     * 请求头
     *
     * @author ultrafrog, ufrog.net@gmail.com
     * @version 0.1, 2018-03-27
     * @since 0.1
     */
    public static class ReqHeader implements Serializable {

        private static final long serialVersionUID = -8008205663967576175L;

        /** 应用编号 */
        private String appId;

        /** 访问令牌 */
        private String accessToken;

        /**
         * 读取应用编号
         *
         * @return 应用编号
         */
        public String getAppId() {
            return appId;
        }

        /**
         * 设置应用编号
         *
         * @param appId 应用编号
         */
        public void setAppId(String appId) {
            this.appId = appId;
        }

        /**
         * 读取访问令牌
         *
         * @return 访问令牌
         */
        public String getAccessToken() {
            return accessToken;
        }

        /**
         * 设置访问令牌
         *
         * @param accessToken 访问令牌
         */
        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
    }
}
