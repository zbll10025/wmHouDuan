package com.example.waimai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("Shop")
public class Shop {
    @TableId(type = IdType.AUTO)
    private Integer sid;

    @TableField("sname")
    private String sname;

    @TableField("stelePhone")
    private String stelePhone;

    @TableField("simgStr")
    private String simgStr;

    @TableField("scroce")
    private String scroce;

    @TableField("salesVolums")
    private Integer salesVolums;

    @TableField("content")
    private String content;

    @TableField("saddress")
    private String saddress;

    // 构造函数
    public Shop() {}

    public Shop(String sname, String stelePhone, String simgStr, String scroce, 
                Integer salesVolums, String content, String saddress) {
        this.sname = sname;
        this.stelePhone = stelePhone;
        this.simgStr = simgStr;
        this.scroce = scroce;
        this.salesVolums = salesVolums;
        this.content = content;
        this.saddress = saddress;
    }

    // Getter和Setter方法
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStelePhone() {
        return stelePhone;
    }

    public void setStelePhone(String stelePhone) {
        this.stelePhone = stelePhone;
    }

    public String getSimgStr() {
        return simgStr;
    }

    public void setSimgStr(String simgStr) {
        this.simgStr = simgStr;
    }

    public String getScroce() {
        return scroce;
    }

    public void setScroce(String scroce) {
        this.scroce = scroce;
    }

    public Integer getSalesVolums() {
        return salesVolums;
    }

    public void setSalesVolums(Integer salesVolums) {
        this.salesVolums = salesVolums;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", stelePhone='" + stelePhone + '\'' +
                ", simgStr='" + simgStr + '\'' +
                ", scroce='" + scroce + '\'' +
                ", salesVolums=" + salesVolums +
                ", content='" + content + '\'' +
                ", saddress='" + saddress + '\'' +
                '}';
    }
}
