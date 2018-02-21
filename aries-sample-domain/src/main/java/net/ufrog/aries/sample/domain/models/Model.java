package net.ufrog.aries.sample.domain.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 模型
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
@MappedSuperclass
public class Model extends ID {

    private static final long serialVersionUID = 3816463068774430969L;

    /** 创建用户 */
    @Column(name = "fk_creator")
    private String creator;

    /** 创建时间 */
    @Column(name = "dt_create_time")
    private Date createTime;

    /** 更新用户 */
    @Column(name = "fk_updater")
    private String updater;

    /** 更新时间 */
    @Column(name = "dt_update_time")
    private Date updateTime;

    /**
     * 读取创建用户
     *
     * @return 创建用户
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建用户
     *
     * @param creator 创建用户
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 读取创建时间
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 读取更新用户
     *
     * @return 更新用户
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 设置更新用户
     *
     * @param updater 更新用户
     */
    public void setUpdater(String updater) {
        this.updater = updater;
    }

    /**
     * 读取更新时间
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
