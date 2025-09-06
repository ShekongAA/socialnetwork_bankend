package com.social_backend.social.repository;

import com.social_backend.social.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {  // 注意这里是 interface，不是 class
    // 根据用户名查找用户（用于判断用户名是否已存在）
    User findByUsername(String username);

    // 判断用户名是否已存在（返回 true/false）
    boolean existsByUsername(String username);
}