package net.ufrog.aries.sample.domain.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 编号
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
@MappedSuperclass
public class ID implements Serializable {

    private static final long serialVersionUID = 6708656201306044261L;

    /** 编号 */
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "net.ufrog.aries.sample.domain.IDGenerator")
    @Column(name = "pk_id")
    private String id;

    /** 是否手动编号 */
    private Boolean _manualId = Boolean.FALSE;

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

    /**
     * 读取是否手动编号
     *
     * @return 是否手动编号
     */
    public Boolean _manualId() {
        return _manualId;
    }

    /**
     * 设置是否手动编号
     *
     * @param _manualId 是否手动编号
     */
    public void _manualId(Boolean _manualId) {
        this._manualId = _manualId;
    }
}
