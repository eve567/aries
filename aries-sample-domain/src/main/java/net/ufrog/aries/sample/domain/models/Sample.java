package net.ufrog.aries.sample.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 样例模型
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
@Entity
@Table(name = "ari_sample")
public class Sample extends Model {

    private static final long serialVersionUID = 4216612043767660941L;

    /** 名称 */
    @Column(name = "vc_name")
    private String name;

    /** 代码 */
    @Column(name = "vc_code")
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
