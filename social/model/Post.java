package com.social_backend.social.model;

import java.time.LocalDateTime;

public class Post {
    private int id;          // 帖子ID
    private String content;  // 帖子内容
    private String author;   // 发帖作者
    private LocalDateTime createTime;
    // 构造方法：用于创建 Post 对象
    public Post(int id, String content, String author, LocalDateTime createTime) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createTime = createTime;
    }

    // Getter 方法（让 Spring Boot 能自动把对象转成 JSON 返回给前端）
    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public  LocalDateTime getCreateTime(){
        return createTime;
    }
    // （可选）Setter 方法（如果后续需要修改 Post 对象的字段，可以加上）
    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public  void setCreateTime(LocalDateTime createTime){
        this.createTime = createTime;
    }
}
