package com.example.waimai.dto;

import java.time.LocalDateTime;

public class OrderFlatRow {
    private Integer bid;
    private Integer gid;
    private LocalDateTime time;
    private Float cost;
    private Integer gcount;
    private Integer billstate;

    private Integer foodGid;
    private String foodGname;
    private String foodGimage;
    private Float foodPrice;
    private Integer foodCid;
    private String foodContent;
    private String foodRemark;
    private Integer foodDiscount;
    private String foodType;
    private Integer foodMonthSale;
    private String foodZhekou;

    private String sname;
    private String simgStr;

    public Integer getBid() { return bid; }
    public void setBid(Integer bid) { this.bid = bid; }

    public Integer getGid() { return gid; }
    public void setGid(Integer gid) { this.gid = gid; }

    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

    public Float getCost() { return cost; }
    public void setCost(Float cost) { this.cost = cost; }

    public Integer getGcount() { return gcount; }
    public void setGcount(Integer gcount) { this.gcount = gcount; }

    public Integer getBillstate() { return billstate; }
    public void setBillstate(Integer billstate) { this.billstate = billstate; }

    public Integer getFoodGid() { return foodGid; }
    public void setFoodGid(Integer foodGid) { this.foodGid = foodGid; }

    public String getFoodGname() { return foodGname; }
    public void setFoodGname(String foodGname) { this.foodGname = foodGname; }

    public String getFoodGimage() { return foodGimage; }
    public void setFoodGimage(String foodGimage) { this.foodGimage = foodGimage; }

    public Float getFoodPrice() { return foodPrice; }
    public void setFoodPrice(Float foodPrice) { this.foodPrice = foodPrice; }

    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }

    public String getSimgStr() { return simgStr; }
    public void setSimgStr(String simgStr) { this.simgStr = simgStr; }

    public Integer getFoodCid() { return foodCid; }
    public void setFoodCid(Integer foodCid) { this.foodCid = foodCid; }

    public String getFoodContent() { return foodContent; }
    public void setFoodContent(String foodContent) { this.foodContent = foodContent; }

    public String getFoodRemark() { return foodRemark; }
    public void setFoodRemark(String foodRemark) { this.foodRemark = foodRemark; }

    public Integer getFoodDiscount() { return foodDiscount; }
    public void setFoodDiscount(Integer foodDiscount) { this.foodDiscount = foodDiscount; }

    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }

    public Integer getFoodMonthSale() { return foodMonthSale; }
    public void setFoodMonthSale(Integer foodMonthSale) { this.foodMonthSale = foodMonthSale; }

    public String getFoodZhekou() { return foodZhekou; }
    public void setFoodZhekou(String foodZhekou) { this.foodZhekou = foodZhekou; }
}


