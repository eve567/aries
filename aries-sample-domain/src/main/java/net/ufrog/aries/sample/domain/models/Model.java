package net.ufrog.aries.sample.domain.models;

import net.ufrog.common.Logger;
import net.ufrog.common.app.App;
import net.ufrog.common.exception.NotSignException;

import javax.persistence.*;
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

    /** 是否手动设置审计字段 */
    private Boolean _manualAudit;

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

    /**
     * 读取是否手动设置审计字段
     *
     * @return 是否手动设置审计字段
     */
    public Boolean _manualAudit() {
        return _manualAudit;
    }

    /**
     * 设置是否手动设置审计字段
     *
     * @param _manualAudit 是否手动设置审计字段
     */
    public void _manualAudit(Boolean _manualAudit) {
        this._manualAudit = _manualAudit;
    }

    /** 持久化前回调 */
    @PrePersist
    protected void onPrePersist() {
        if (_manualAudit()) return;
        creator = getAppUserId();
        createTime = new Date();
        updater = creator;
        updateTime = new Date();
    }

    /** 持久化后回调 */
    @PostPersist
    protected void onPostPersist() {
        Logger.debug("insert data '{}: {}'.", getClass().getSimpleName(), toString());
    }

    /** 更新前回调 */
    @PreUpdate
    protected void onPreUpdate() {
        updater = getAppUserId();
        updateTime = new Date();
    }

    @Override
    public String toString() {
        return getId();
    }

    /**
     * 读取应用用户编号
     *
     * @return 应用用户编号
     */
    private String getAppUserId() {
        try {
            return App.user().getId();
        } catch (NotSignException e) {
            return null;
        } catch (Throwable e) {
            Logger.warn(e.getMessage(), e);
            return null;
        }
    }
}
