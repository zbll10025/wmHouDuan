package com.example.waimai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.waimai.entity.Bill;
import com.example.waimai.dto.OrderFlatRow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BillMapper extends BaseMapper<Bill> {
    @Select("SELECT b.bid, b.gid, b.time, b.cost, b.gcount, b.billstate, " +
            "g.gid AS foodGid, g.gname AS foodGname, g.gimage AS foodGimage, g.price AS foodPrice, " +
            "g.cid AS foodCid, g.content AS foodContent, g.remark AS foodRemark, g.discount AS foodDiscount, " +
            "g.type AS foodType, g.month_sale AS foodMonthSale, g.zhekou AS foodZhekou, " +
            "s.sname AS sname, s.simgStr AS simgStr " +
            "FROM Bill b " +
            "JOIN Goods g ON b.gid = g.gid " +
            "JOIN Category c ON g.cid = c.cid " +
            "JOIN Shop s ON c.sid = s.sid " +
            "WHERE b.uid = #{uid} " +
            "ORDER BY b.time DESC")
    java.util.List<OrderFlatRow> selectOrdersByUserId(@Param("uid") Integer uid);
}
