package com.social_backend.social;

import com.social_backend.social.model.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class UserController {

    // 模拟“已注册用户”的存储（key: username, value: 加密后的密码）
    // 实际项目中要去数据库查！这里先用 Map 代替
    private static final Map<String, String> registeredUsers = new HashMap<>();

    // 密码加密工具
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String register(@RequestBody RegisterRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        // 1. 检查用户名是否已存在
        if (registeredUsers.containsKey(username)) {
            return "用户名已被占用，请换一个～";
        }

        // 2. 加密密码
        String encodedPassword = passwordEncoder.encode(password);

        // 3. 存入“模拟数据库”
        registeredUsers.put(username, encodedPassword);

        return "注册成功！用户名：" + username;
    }
}