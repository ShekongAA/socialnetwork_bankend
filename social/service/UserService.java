package com.social_backend.social.service;

import com.social_backend.social.model.User;
import com.social_backend.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("用户名已存在！");
        }
        // 加密密码
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    // 测试方法：插入一条数据并查询
    public void testRepository() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("123456");
        user.setEmail("test@example.com");

        // 保存到数据库
        userRepository.save(user);

        // 查询用户名是否存在
        boolean exists = userRepository.existsByUsername("testuser");
        System.out.println("用户名是否存在？ " + exists);  // 应该输出 true

        // 根据用户名查询
        User foundUser = userRepository.findByUsername("testuser");
        System.out.println("查询到的用户：" + foundUser.getUsername());  // 应该输出 "testuser"
    }
}
