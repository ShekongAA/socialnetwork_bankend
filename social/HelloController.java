package com.social_backend.social; // 确保包名和你实际的一致

import com.social_backend.social.model.User;
import com.social_backend.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private UserService userService;

    // 测试注册接口
    @PostMapping("/hello/register")
    public String register(@RequestBody User user) {
        //处理注册逻辑
        return "Hello, " + user.getUsername() + "!";
    }
}