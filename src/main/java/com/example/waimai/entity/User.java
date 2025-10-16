package com.example.waimai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("User")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String name;
    
    private String password;

    private String telePhone;
    
    private Float balance;

    // 构造函数
    public User() {}

    public User(String name, String password, String telePhone, Float balance) {
        this.name = name;
        this.password = password;
        this.telePhone = telePhone;
        this.balance = balance;
    }

    // Getter和Setter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telePhone='" + telePhone + '\'' +
                ", balance=" + balance +
                '}';
    }
}
