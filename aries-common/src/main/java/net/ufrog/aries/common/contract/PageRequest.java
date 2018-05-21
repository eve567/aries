package net.ufrog.aries.common.contract;

import java.io.Serializable;

/**
 * 分页请求
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 4.0.1, 2018-05-18
 * @since 4.0.1
 */
public class PageRequest extends Request {

    /** 分页信息 */
    private Pagination pagination;

    /** 构造函数 */
    public PageRequest() {
        pagination = new Pagination();
    }

    /**
     * 读取分页信息
     *
     * @return 分页信息
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 设置分页信息
     *
     * @param pagination 分页信息
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * 请求分页
     *
     * @author ultrafrog, ufrog.net@gmail.com
     * @version 0.0.1, 2018-04-08
     * @since 0.0.1
     */
    public static class Pagination implements Serializable {

        private static final long serialVersionUID = 5644370339378908461L;

        /** 单页数据量 */
        private Integer size;

        /** 目标页码 */
        private Integer target;

        /** 构造函数 */
        public Pagination() {
            this.size = Integer.MAX_VALUE;
            this.target = 0;
        }

        /**
         * 构造函数
         *
         * @param size 单页数据量
         * @param target 目标页码
         */
        public Pagination(Integer size, Integer target) {
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
