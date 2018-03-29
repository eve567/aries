package net.ufrog.aries.sample.client.contract;

import net.ufrog.aries.common.contract.Req;

/**
 * 编号请求
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-22
 * @since 0.1
 */
public class IdReq extends Req {

    private static final long serialVersionUID = -8013865544734108346L;

    /** 编号 */
    private String id;

    /**
     * 读取编号
     *
     * @return 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }
}
