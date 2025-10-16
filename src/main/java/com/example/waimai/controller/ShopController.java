package com.example.waimai.controller;

import com.example.waimai.entity.Shop;
import com.example.waimai.mapper.ShopMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
@Tag(name = "店铺管理", description = "店铺相关操作")
public class ShopController {

    @Autowired
    private ShopMapper shopMapper;

    @GetMapping
    @Operation(summary = "获取所有店铺")
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopMapper.selectList(null);
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取店铺")
    public ResponseEntity<Shop> getShopById(@PathVariable Integer id) {
        Shop shop = shopMapper.selectById(id);
        if (shop != null) {
            return ResponseEntity.ok(shop);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "创建店铺")
    public ResponseEntity<String> createShop(@RequestBody Shop shop) {
        if (shopMapper.insert(shop) > 0) {
            return ResponseEntity.ok("店铺创建成功");
        }
        return ResponseEntity.badRequest().body("店铺创建失败");
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新店铺信息")
    public ResponseEntity<String> updateShop(@PathVariable Integer id, @RequestBody Shop shop) {
        shop.setSid(id);
        if (shopMapper.updateById(shop) > 0) {
            return ResponseEntity.ok("店铺更新成功");
        }
        return ResponseEntity.badRequest().body("店铺更新失败");
    }

    @GetMapping("/refresh")
    @Operation(summary = "获取5个未获取的商店信息", description = "用于上拉刷新，需要传入offset参数")
    public ResponseEntity<List<Shop>> getShopsForRefresh(@RequestParam(defaultValue = "0") Integer offset) {
        List<Shop> shops = shopMapper.selectShopsWithOffset(offset);
        return ResponseEntity.ok(shops);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除店铺")
    public ResponseEntity<String> deleteShop(@PathVariable Integer id) {
        if (shopMapper.deleteById(id) > 0) {
            return ResponseEntity.ok("店铺删除成功");
        }
        return ResponseEntity.badRequest().body("店铺删除失败");
    }
}
