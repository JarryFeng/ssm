package com.feng.work.entity;

import java.util.Date;

/**
 * Created by jarry on 2017/6/20.
 */
public class ScheduleEntity {
    private Integer id;

    private String cronExpresion;

    private String triggerName;

    private String status;

    private Date createdate;

    private Date updatedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCronExpresion() {
        return cronExpresion;
    }

    public void setCronExpresion(String cronExpresion) {
        this.cronExpresion = cronExpresion;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
}
