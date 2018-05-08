package net.ufrog.aries.sample.client.contracts;

import net.ufrog.aries.common.contract.Response;

/**
 * 样例对象
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
public class SampleResponse extends Response {

    private static final long serialVersionUID = 6275758945866865457L;

    /** 名称 */
    private String name;

    /** 代码 */
    private String code;

    /**
     * 读取名称
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 读取代码
     *
     * @return 代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置代码
     *
     * @param code 代码
     */
    public void setCode(String code) {
        this.code = code;
    }
}
