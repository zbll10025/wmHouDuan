package com.example.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.waimai.entity.Category;
import com.example.waimai.entity.Goods;
import com.example.waimai.mapper.CategoryMapper;
import com.example.waimai.mapper.GoodsMapper;
import com.example.waimai.dto.CategoryWithGoodsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "分类管理", description = "商品分类相关操作")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping
    @Operation(summary = "获取所有分类")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryMapper.selectList(null);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取分类")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        Category category = categoryMapper.selectById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/shop/{shopId}")
    @Operation(summary = "根据店铺ID获取分类")
    public ResponseEntity<List<Category>> getCategoriesByShopId(@PathVariable Integer shopId) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", shopId);
        List<Category> categories = categoryMapper.selectList(queryWrapper);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/shop/{shopId}/with-goods")
    @Operation(summary = "根据店铺ID获取分类及其商品", description = "返回包含foods字段的分类数据，用于前端Category数组")
    public ResponseEntity<List<CategoryWithGoodsDTO>> getCategoriesWithGoodsByShopId(@PathVariable Integer shopId) {
        // 1) 查询该店铺下的所有分类
        List<Category> categories = categoryMapper.selectList(new QueryWrapper<Category>().eq("sid", shopId));
        if (categories == null || categories.isEmpty()) {
            return ResponseEntity.ok(List.of());
        }

        // 2) 提取所有分类ID，一次性查询这些分类下的所有商品
        List<Integer> categoryIds = categories.stream().map(Category::getCid).collect(Collectors.toList());
        List<Goods> allGoods = goodsMapper.selectList(new QueryWrapper<Goods>().in("cid", categoryIds));

        // 3) 将商品按分类ID分组
        Map<Integer, List<Goods>> goodsByCategoryId = allGoods.stream().collect(Collectors.groupingBy(Goods::getCid));

        // 4) 组装DTO，字段名对齐前端：name <- cname, foods <- goods list
        List<CategoryWithGoodsDTO> result = categories.stream().map(c -> {
            List<Goods> foods = goodsByCategoryId.getOrDefault(c.getCid(), List.of());
            return new CategoryWithGoodsDTO(c.getCid(), c.getCname(), foods);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/goods/{goodsId}/shop-categories")
    @Operation(summary = "根据商品ID获取该商品所在店铺的所有分类及商品", description = "用于点击商品跳转到购物页面，返回Category数组")
    public ResponseEntity<List<CategoryWithGoodsDTO>> getShopCategoriesByGoodsId(@PathVariable Integer goodsId) {
        // 1) 通过商品ID查询商品信息，获取分类ID
        Goods goods = goodsMapper.selectById(goodsId);
        if (goods == null || goods.getCid() == null) {
            return ResponseEntity.notFound().build();
        }

        // 2) 通过分类ID查询分类信息，获取店铺ID
        Category category = categoryMapper.selectById(goods.getCid());
        if (category == null || category.getSid() == null) {
            return ResponseEntity.notFound().build();
        }

        // 3) 查询该店铺下的所有分类
        List<Category> categories = categoryMapper.selectList(new QueryWrapper<Category>().eq("sid", category.getSid()));
        if (categories == null || categories.isEmpty()) {
            return ResponseEntity.ok(List.of());
        }

        // 4) 提取所有分类ID，一次性查询这些分类下的所有商品
        List<Integer> categoryIds = categories.stream().map(Category::getCid).collect(Collectors.toList());
        List<Goods> allGoods = goodsMapper.selectList(new QueryWrapper<Goods>().in("cid", categoryIds));

        // 5) 将商品按分类ID分组
        Map<Integer, List<Goods>> goodsByCategoryId = allGoods.stream().collect(Collectors.groupingBy(Goods::getCid));

        // 6) 组装DTO，字段名对齐前端：name <- cname, foods <- goods list
        List<CategoryWithGoodsDTO> result = categories.stream().map(c -> {
            List<Goods> foods = goodsByCategoryId.getOrDefault(c.getCid(), List.of());
            return new CategoryWithGoodsDTO(c.getCid(), c.getCname(), foods);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @PostMapping
    @Operation(summary = "创建分类")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        if (categoryMapper.insert(category) > 0) {
            return ResponseEntity.ok("分类创建成功");
        }
        return ResponseEntity.badRequest().body("分类创建失败");
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新分类信息")
    public ResponseEntity<String> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        category.setCid(id);
        if (categoryMapper.updateById(category) > 0) {
            return ResponseEntity.ok("分类更新成功");
        }
        return ResponseEntity.badRequest().body("分类更新失败");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除分类")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        if (categoryMapper.deleteById(id) > 0) {
            return ResponseEntity.ok("分类删除成功");
        }
        return ResponseEntity.badRequest().body("分类删除失败");
    }
}
