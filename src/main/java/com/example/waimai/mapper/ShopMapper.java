package com.example.waimai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.waimai.entity.Shop;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopMapper extends BaseMapper<Shop> {
    
    /**
     * 获取5个未获取的商店信息（用于上拉刷新）
     * @param offset 偏移量，表示跳过多少个商店
     * @return 5个商店信息列表
     */
    @Select("SELECT * FROM Shop ORDER BY sid LIMIT #{offset}, 5")
    List<Shop> selectShopsWithOffset(@Param("offset") Integer offset);
}
