package com.example.waimai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("Address")
public class Address {
    @TableId(type = IdType.AUTO)
    private Integer aid;
    
    private String address;
    
    private Integer uid;

    // 构造函数
    public Address() {}

    public Address(String address, Integer uid) {
        this.address = address;
        this.uid = uid;
    }

    // Getter和Setter方法
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", address='" + address + '\'' +
                ", uid=" + uid +
                '}';
    }
}
