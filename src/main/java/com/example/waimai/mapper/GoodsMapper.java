package com.example.waimai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.waimai.entity.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {
    
    /**
     * 随机选择4种商品（用于下拉刷新推荐商品）
     * @return 随机选择的4种商品列表
     */
    @Select("SELECT * FROM Goods ORDER BY RAND() LIMIT 4")
    List<Goods> selectRandomGoods();
}
