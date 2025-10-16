package com.example.waimai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("Goods")
public class Goods {
    @TableId(type = IdType.AUTO)
    private Integer gid;
    
    private Integer cid;
    
    private String gname;
    
    private String gimage;
    
    private String content;
    
    private String remark;
    
    private Integer discount;
    
    private Float price;
    
    private String type;
    
    private Integer monthSale;
    
    private String zhekou;

    // 构造函数
    public Goods() {}

    public Goods(Integer cid, String gname, String gimage, String content, String remark, 
                 Integer discount, Float price, String type, Integer monthSale, String zhekou) {
        this.cid = cid;
        this.gname = gname;
        this.gimage = gimage;
        this.content = content;
        this.remark = remark;
        this.discount = discount;
        this.price = price;
        this.type = type;
        this.monthSale = monthSale;
        this.zhekou = zhekou;
    }

    // Getter和Setter方法
    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGimage() {
        return gimage;
    }

    public void setGimage(String gimage) {
        this.gimage = gimage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMonthSale() {
        return monthSale;
    }

    public void setMonthSale(Integer monthSale) {
        this.monthSale = monthSale;
    }

    public String getZhekou() {
        return zhekou;
    }

    public void setZhekou(String zhekou) {
        this.zhekou = zhekou;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", cid=" + cid +
                ", gname='" + gname + '\'' +
                ", gimage='" + gimage + '\'' +
                ", content='" + content + '\'' +
                ", remark='" + remark + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", monthSale=" + monthSale +
                ", zhekou='" + zhekou + '\'' +
                '}';
    }
}
