package com.example.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.waimai.entity.Goods;
import com.example.waimai.mapper.GoodsMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
@Tag(name = "商品管理", description = "商品相关操作")
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping
    @Operation(summary = "获取所有商品")
    public ResponseEntity<List<Goods>> getAllGoods() {
        List<Goods> goods = goodsMapper.selectList(null);
        return ResponseEntity.ok(goods);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取商品")
    public ResponseEntity<Goods> getGoodsById(@PathVariable Integer id) {
        Goods goods = goodsMapper.selectById(id);
        if (goods != null) {
            return ResponseEntity.ok(goods);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "根据分类ID获取商品")
    public ResponseEntity<List<Goods>> getGoodsByCategoryId(@PathVariable Integer categoryId) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid", categoryId);
        List<Goods> goods = goodsMapper.selectList(queryWrapper);
        return ResponseEntity.ok(goods);
    }

    @PostMapping
    @Operation(summary = "创建商品")
    public ResponseEntity<String> createGoods(@RequestBody Goods goods) {
        if (goodsMapper.insert(goods) > 0) {
            return ResponseEntity.ok("商品创建成功");
        }
        return ResponseEntity.badRequest().body("商品创建失败");
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新商品信息")
    public ResponseEntity<String> updateGoods(@PathVariable Integer id, @RequestBody Goods goods) {
        goods.setGid(id);
        if (goodsMapper.updateById(goods) > 0) {
            return ResponseEntity.ok("商品更新成功");
        }
        return ResponseEntity.badRequest().body("商品更新失败");
    }

    @GetMapping("/random")
    @Operation(summary = "随机选择4种商品", description = "用于下拉刷新推荐商品")
    public ResponseEntity<List<Goods>> getRandomGoods() {
        List<Goods> goods = goodsMapper.selectRandomGoods();
        return ResponseEntity.ok(goods);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除商品")
    public ResponseEntity<String> deleteGoods(@PathVariable Integer id) {
        if (goodsMapper.deleteById(id) > 0) {
            return ResponseEntity.ok("商品删除成功");
        }
        return ResponseEntity.badRequest().body("商品删除失败");
    }
}
