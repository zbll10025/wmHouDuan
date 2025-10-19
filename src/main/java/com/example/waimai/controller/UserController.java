package com.example.waimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.waimai.entity.User;
import com.example.waimai.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "用户管理", description = "用户相关操作")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    @Operation(summary = "获取所有用户")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userMapper.selectList(null);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取用户")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userMapper.selectById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "创建用户")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // 检查用户名是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        if (userMapper.selectOne(queryWrapper) != null) {
            return ResponseEntity.badRequest().body("用户名已存在");
        }
        // 新注册用户余额默认设为0，不从前端接收
        user.setBalance(0f);
        if (userMapper.insert(user) > 0) {
            return ResponseEntity.ok("用户创建成功");
        }
        return ResponseEntity.badRequest().body("用户创建失败");
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新用户信息")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        if (userMapper.updateById(user) > 0) {
            return ResponseEntity.ok("用户更新成功");
        }
        return ResponseEntity.badRequest().body("用户更新失败");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        if (userMapper.deleteById(id) > 0) {
            return ResponseEntity.ok("用户删除成功");
        }
        return ResponseEntity.badRequest().body("用户删除失败");
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public ResponseEntity<User> login(@RequestParam String name, @RequestParam String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name).eq("password", password);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}/balance")
    @Operation(summary = "更新用户余额")
    public ResponseEntity<String> updateBalance(@PathVariable Integer id, @RequestParam Float amount) {
        User user = userMapper.selectById(id);
        if (user != null) {
            user.setBalance(user.getBalance() + amount);
            if (userMapper.updateById(user) > 0) {
                return ResponseEntity.ok("余额更新成功");
            }
        }
        return ResponseEntity.badRequest().body("余额更新失败");
    }
}
