package com.example.waimai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

@TableName("Bill")
public class Bill {
    @TableId(type = IdType.AUTO)
    private Integer bid;
    
    private Integer uid;
    
    private Integer gid;
    
    private Float cost;
    
    private LocalDateTime time;
    
    private Integer gcount;
    
    private Integer billstate;

    // 构造函数
    public Bill() {}

    public Bill(Integer uid, Integer gid, Float cost, LocalDateTime time, 
                Integer gcount, Integer billstate) {
        this.uid = uid;
        this.gid = gid;
        this.cost = cost;
        this.time = time;
        this.gcount = gcount;
        this.billstate = billstate;
    }

    // Getter和Setter方法
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    public Integer getBillstate() {
        return billstate;
    }

    public void setBillstate(Integer billstate) {
        this.billstate = billstate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bid=" + bid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", cost=" + cost +
                ", time=" + time +
                ", gcount=" + gcount +
                ", billstate='" + billstate + '\'' +
                '}';
    }
}
