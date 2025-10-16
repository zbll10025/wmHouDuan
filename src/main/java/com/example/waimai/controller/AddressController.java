package com.example.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.waimai.entity.Address;
import com.example.waimai.mapper.AddressMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@Tag(name = "地址管理", description = "用户地址相关操作")
public class AddressController {

    @Autowired
    private AddressMapper addressMapper;

    @GetMapping
    @Operation(summary = "获取所有地址")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressMapper.selectList(null);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取地址")
    public ResponseEntity<Address> getAddressById(@PathVariable Integer id) {
        Address address = addressMapper.selectById(id);
        if (address != null) {
            return ResponseEntity.ok(address);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "根据用户ID获取地址")
    public ResponseEntity<List<Address>> getAddressesByUserId(@PathVariable Integer userId) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", userId);
        List<Address> addresses = addressMapper.selectList(queryWrapper);
        return ResponseEntity.ok(addresses);
    }

    @PostMapping
    @Operation(summary = "创建地址")
    public ResponseEntity<String> createAddress(@RequestBody Address address) {
        if (addressMapper.insert(address) > 0) {
            return ResponseEntity.ok("地址创建成功");
        }
        return ResponseEntity.badRequest().body("地址创建失败");
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新地址信息")
    public ResponseEntity<String> updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        address.setAid(id);
        if (addressMapper.updateById(address) > 0) {
            return ResponseEntity.ok("地址更新成功");
        }
        return ResponseEntity.badRequest().body("地址更新失败");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除地址")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {
        if (addressMapper.deleteById(id) > 0) {
            return ResponseEntity.ok("地址删除成功");
        }
        return ResponseEntity.badRequest().body("地址删除失败");
    }
}
