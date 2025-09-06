package com.social_backend.social.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user") // 显式指定表名（默认类名小写）
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    private Long id;

    @Column(unique = true, nullable = false) // 用户名唯一且非空
    private String username;

    @Column(nullable = false) // 密码非空（后续加密）
    private String password;

    // 其他字段（如 email、昵称等）
    //private String email;

    // Getter 和 Setter 方法（Lombok 可简化）
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}