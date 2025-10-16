package com.example.waimai.dto;

import com.example.waimai.entity.Goods;

import java.util.List;

public class CategoryWithGoodsDTO {
    private Integer cid;
    private String name;
    private List<Goods> foods;

    public CategoryWithGoodsDTO() {
    }

    public CategoryWithGoodsDTO(Integer cid, String name, List<Goods> foods) {
        this.cid = cid;
        this.name = name;
        this.foods = foods;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getFoods() {
        return foods;
    }

    public void setFoods(List<Goods> foods) {
        this.foods = foods;
    }
}


