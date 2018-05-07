package net.ufrog.aries.common.contract;

import java.io.Serializable;

/**
 * 基础请求
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.0.1, 2018-03-27
 * @since 0.0.1
 */
public class Req implements Serializable {

    private static final long serialVersionUID = 1755816194688390660L;

    /** 请求头 */
    private ReqHeader reqHeader;

    /** 请求分页 */
    private ReqPage reqPage;

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
     * 读取请求分页
     *
     * @return 请求分页
     */
    public ReqPage getReqPage() {
        return reqPage;
    }

    /**
     * 设置请求分页
     *
     * @param reqPage 请求分页
     */
    public void setReqPage(ReqPage reqPage) {
        this.reqPage = reqPage;
    }

    /**
     * 请求头
     *
     * @author ultrafrog, ufrog.net@gmail.com
     * @version 0.0.1, 2018-03-27
     * @since 0.0.1
     */
    public static class ReqHeader implements Serializable {

        private static final long serialVersionUID = -8008205663967576175L;

        /** 应用编号 */
        private String appId;

        /** 访问令牌 */
        private String accessToken;

        /** 签名 */
        private String signature;

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

        /**
         * 读取签名
         *
         * @return 签名
         */
        public String getSignature() {
            return signature;
        }

        /**
         * 设置签名
         *
         * @param signature 签名
         */
        public void setSignature(String signature) {
            this.signature = signature;
        }
    }

    /**
     * 请求分页
     *
     * @author ultrafrog, ufrog.net@gmail.com
     * @version 0.0.1, 2018-04-08
     * @since 0.0.1
     */
    public static class ReqPage implements Serializable {

        private static final long serialVersionUID = 5644370339378908461L;

        /** 单页数据量 */
        private Integer size;

        /** 目标页码 */
        private Integer target;

        /** 构造函数 */
        public ReqPage() {
            this.size = Integer.MAX_VALUE;
            this.target = 0;
        }

        /**
         * 构造函数
         *
         * @param size 单页数据量
         * @param target 目标页码
         */
        public ReqPage(Integer size, Integer target) {
            this.size = size;
            this.target = target;
        }

        /**
         * 读取单页数据量
         *
         * @return 单页数据量
         */
        public Integer getSize() {
            return size;
        }

        /**
         * 设置单页数据量
         *
         * @param size 单页数据量
         */
        public void setSize(Integer size) {
            this.size = size;
        }

        /**
         * 读取目标页码
         *
         * @return 目标页码
         */
        public Integer getTarget() {
            return target;
        }

        /**
         * 设置目标页码
         *
         * @param target 目标页码
         */
        public void setTarget(Integer target) {
            this.target = target;
        }
    }
}
