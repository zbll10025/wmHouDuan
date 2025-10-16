package com.example.waimai.dto;

import com.example.waimai.entity.Goods;

import java.time.format.DateTimeFormatter;

public class OrderPayload {
    // Bill fields
    private Integer bid;
    private Integer gid;
    private String time; // ISO string
    private Float cost;
    private Integer gcount;
    private Integer billstate;

    // Goods & Shop display fields
    private Goods food; // expect at least gid, gname, gimage, price present
    private String sname;
    private String simgStr;

    public Integer getBid() { return bid; }
    public void setBid(Integer bid) { this.bid = bid; }
    public Integer getGid() { return gid; }
    public void setGid(Integer gid) { this.gid = gid; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public Float getCost() { return cost; }
    public void setCost(Float cost) { this.cost = cost; }
    public Integer getGcount() { return gcount; }
    public void setGcount(Integer gcount) { this.gcount = gcount; }
    public Integer getBillstate() { return billstate; }
    public void setBillstate(Integer billstate) { this.billstate = billstate; }
    public Goods getFood() { return food; }
    public void setFood(Goods food) { this.food = food; }
    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }
    public String getSimgStr() { return simgStr; }
    public void setSimgStr(String simgStr) { this.simgStr = simgStr; }

    public static OrderPayload fromRow(OrderFlatRow row) {
        OrderPayload p = new OrderPayload();
        p.setBid(row.getBid());
        p.setGid(row.getGid());
        p.setTime(row.getTime() != null ? row.getTime().toString() : null);
        p.setCost(row.getCost());
        p.setGcount(row.getGcount());
        p.setBillstate(row.getBillstate());

        Goods g = new Goods();
        g.setGid(row.getFoodGid());
        g.setGname(row.getFoodGname());
        g.setGimage(row.getFoodGimage());
        g.setPrice(row.getFoodPrice());
        g.setCid(row.getFoodCid());
        g.setContent(row.getFoodContent());
        g.setRemark(row.getFoodRemark());
        g.setDiscount(row.getFoodDiscount());
        g.setType(row.getFoodType());
        g.setMonthSale(row.getFoodMonthSale());
        g.setZhekou(row.getFoodZhekou());
        p.setFood(g);

        p.setSname(row.getSname());
        p.setSimgStr(row.getSimgStr());
        return p;
    }
}


