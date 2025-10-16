package com.example.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.waimai.entity.Bill;
import com.example.waimai.mapper.BillMapper;
import com.example.waimai.dto.OrderFlatRow;
import com.example.waimai.dto.OrderPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bills")
@Tag(name = "订单管理", description = "订单相关操作")
public class BillController {

    @Autowired
    private BillMapper billMapper;

    @GetMapping
    @Operation(summary = "获取所有订单")
    public ResponseEntity<List<Bill>> getAllBills() {
        List<Bill> bills = billMapper.selectList(null);
        return ResponseEntity.ok(bills);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取订单")
    public ResponseEntity<Bill> getBillById(@PathVariable Integer id) {
        Bill bill = billMapper.selectById(id);
        if (bill != null) {
            return ResponseEntity.ok(bill);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "根据用户ID获取订单（扁平化payload）")
    public ResponseEntity<List<OrderPayload>> getOrdersByUserId(@PathVariable Integer userId) {
        List<OrderFlatRow> rows = billMapper.selectOrdersByUserId(userId);
        List<OrderPayload> payload = rows.stream().map(OrderPayload::fromRow).collect(Collectors.toList());
        return ResponseEntity.ok(payload);
    }

    @PostMapping
    @Operation(summary = "创建订单")
    public ResponseEntity<String> createBill(@RequestBody Bill bill) {
        bill.setTime(LocalDateTime.now());
        if (billMapper.insert(bill) > 0) {
            return ResponseEntity.ok("订单创建成功");
        }
        return ResponseEntity.badRequest().body("订单创建失败");
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新订单信息")
    public ResponseEntity<String> updateBill(@PathVariable Integer id, @RequestBody Bill bill) {
        bill.setBid(id);
        if (billMapper.updateById(bill) > 0) {
            return ResponseEntity.ok("订单更新成功");
        }
        return ResponseEntity.badRequest().body("订单更新失败");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除订单")
    public ResponseEntity<String> deleteBill(@PathVariable Integer id) {
        if (billMapper.deleteById(id) > 0) {
            return ResponseEntity.ok("订单删除成功");
        }
        return ResponseEntity.badRequest().body("订单删除失败");
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "更新订单状态")
    public ResponseEntity<String> updateBillStatus(@PathVariable Integer id, @RequestParam int status) {
        Bill bill = billMapper.selectById(id);
        if (bill != null) {
            bill.setBillstate(status);
            if (billMapper.updateById(bill) > 0) {
                return ResponseEntity.ok("订单状态更新成功");
            }
        }
        return ResponseEntity.badRequest().body("订单状态更新失败");
    }
}
