package com.test.all.mysql;


import java.io.Serializable;
import java.util.Date;

public class Tb1 implements Serializable {
    private Long id;
    private Byte f1Byte;
    private Integer f2Int;
    private String f3Varchar;
    private Date f4Datetime;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getF1Byte() {
        return f1Byte;
    }

    public void setF1Byte(Byte f1Byte) {
        this.f1Byte = f1Byte;
    }

    public Integer getF2Int() {
        return f2Int;
    }

    public void setF2Int(Integer f2Int) {
        this.f2Int = f2Int;
    }

    public String getF3Varchar() {
        return f3Varchar;
    }

    public void setF3Varchar(String f3Varchar) {
        this.f3Varchar = f3Varchar;
    }

    public Date getF4Datetime() {
        return f4Datetime;
    }

    public void setF4Datetime(Date f4Datetime) {
        this.f4Datetime = f4Datetime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
