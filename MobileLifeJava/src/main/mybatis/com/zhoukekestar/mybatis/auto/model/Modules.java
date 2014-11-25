package com.zhoukekestar.mybatis.auto.model;

public class Modules {
    private Integer moduleId;

    private String modulePath;

    private String modulePattern;

    private Byte status;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModulePath() {
        return modulePath;
    }

    public void setModulePath(String modulePath) {
        this.modulePath = modulePath == null ? null : modulePath.trim();
    }

    public String getModulePattern() {
        return modulePattern;
    }

    public void setModulePattern(String modulePattern) {
        this.modulePattern = modulePattern == null ? null : modulePattern.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}