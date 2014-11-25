package com.zhoukekestar.mybatis.auto.model;

import java.util.Date;

public class LedLog {
    private Integer id;

    private Integer userId;

    private Integer ledId;

    private String action;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLedId() {
        return ledId;
    }

    public void setLedId(Integer ledId) {
        this.ledId = ledId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}