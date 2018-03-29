package net.ufrog.aries.common.contract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 列表响应
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-03-29
 * @since 0.1
 */
public class ListResp<T extends Resp> extends Resp {

    private static final long serialVersionUID = -8818533468144993724L;

    /** 数据内容 */
    private List<T> content;

    /** 构造函数 */
    ListResp() {
        content = new ArrayList<>();
    }

    /**
     * 构造函数
     *
     * @param content 数据内容
     */
    public ListResp(Collection<T> content) {
        this.content.addAll(content);
    }

    /**
     * 读取数据内容
     *
     * @return 数据内容
     */
    public List<T> getContent() {
        return content;
    }

    /**
     * 判断数据集合是否为空
     *
     * @return 判断结果
     */
    public Boolean isEmpty() {
        return content.isEmpty();
    }
}
