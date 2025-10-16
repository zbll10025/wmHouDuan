package com.example.waimai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("Category")
public class Category {
    @TableId(type = IdType.AUTO)
    private Integer cid;
    
    private Integer sid;
    
    private String cname;

    // 构造函数
    public Category() {}

    public Category(Integer sid, String cname) {
        this.sid = sid;
        this.cname = cname;
    }

    // Getter和Setter方法
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", sid=" + sid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
