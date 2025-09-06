package com.social_backend.social; // 你的控制器包名，根据实际情况调整

import com.social_backend.social.model.Post; // ✅ 正确导入你放在 model 包下的 Post 类
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/posts") // 这个类里所有接口的基础路径是 /posts
public class PostController {

    // 模拟存储帖子的 List（替代数据库，重启后数据会丢失）
    private static final List<Post> posts = new ArrayList<>();

    // 用于生成帖子 id（自增）
    private static final AtomicInteger nextId = new AtomicInteger(1);

    // ✅ 发布帖子接口：POST /posts/create
    @PostMapping("/create")
    public Map<String, Object> createPost(@RequestBody CreatePostRequest request) {
        String content = request.getContent();
        String author = request.getAuthor();

        // 简单校验：内容不能为空
        if (content == null || content.trim().isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("code", 1);
            response.put("message", "帖子内容不能为空！");
            return response;
        }

        // 创建一个新的 Post 对象（使用你 model 包下的 Post 类）
        Post newPost = new Post(nextId.getAndIncrement(), content, author, LocalDateTime.now());

        // 存储到 posts 列表中
        posts.add(newPost);

        // 返回成功响应
        Map<String, Object> response = new HashMap<>();
        response.put("code", 0);
        response.put("message", "帖子发布成功！");
        return response;
    }

    // ✅ 内部类：用于接收前端发来的帖子数据（JSON 格式）
    public static class CreatePostRequest {
        private String content;
        private String author;

        // 必须提供 getter 和 setter，Spring Boot 才能正确映射 JSON 字段
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    // （可选）如果你想测试帖子列表接口，可以加一个 GET /posts 接口返回所有帖子
    @GetMapping
    public List<Post> getAllPosts() {
        // 按 id 倒序排序（假设 id 是自增的，越大的越新）
        List<Post> sortedPosts = new ArrayList<>(posts);
        sortedPosts.sort((a, b) -> b.getCreateTime().compareTo(a.getCreateTime())); // 降序
        return sortedPosts;
    }
}