package net.ufrog.aries.common.contract;

import java.util.Collection;

/**
 * 分页响应
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-03-29
 * @since 0.1
 */
public class PageResp<T extends Resp> extends ListResp<T> {

    private static final long serialVersionUID = 43920421001937001L;

    /** 数据总量 */
    private Long count;

    /** 分页大小 */
    private Integer size;

    /** 当前页号 */
    private Integer page;

    /** 构造函数 */
    private PageResp() {
        super();
    }

    /**
     * 构造函数
     *
     * @param count 数据总量
     * @param size 分页大小
     * @param page 当前页号
     */
    public PageResp(Long count, Integer size, Integer page, Collection<T> content) {
        this();
        this.count = count;
        this.size = size;
        this.page = page;
        this.getContent().addAll(content);
    }

    /**
     * 读取数据总量
     *
     * @return 数据总量
     */
    public Long getCount() {
        return count;
    }

    /**
     * 读取分页大小
     *
     * @return 分页大小
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 读取当前页号
     *
     * @return 当前页号
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 读取分页总量
     *
     * @return 分页总量
     */
    public Integer getPageCount() {
        if (size != null && count != null && size != 0) {
            return (int) Math.ceil((double) count / (double) size);
        }
        return 0;
    }

    /**
     * 读取当前页数据量
     *
     * @return 当前页数据量
     */
    public Integer getNumber() {
        return getContent().size();
    }

    /**
     * 判断是否为首页
     *
     * @return 判断结果
     */
    public Boolean isFirstPage() {
        return page == 0;
    }

    /**
     * 判断是否为尾页
     *
     * @return 判断结果
     */
    public Boolean isLastPage() {
        return page == (getPageCount() - 1);
    }
}
