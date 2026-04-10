package com.blogger.blogger_box_backend.controller;

import com.blogger.blogger_box_backend.dto.CreateCategoryRequest;
import com.blogger.blogger_box_backend.dto.PostRequest;
import com.blogger.blogger_box_backend.model.Post;
import com.blogger.blogger_box_backend.services.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Posts Apis", description = "les differents endpoint de l'api post")

@RequestMapping("/v1/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("")
    @Operation(description = "Get all posts")
    public ResponseEntity<List<Post>> getPost(@RequestParam(required = false) String title) {
        List<Post> posts = title == null || title.isBlank()
                ? service.getPost()
                : service.findAllLikeTitle(title);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}/posts")
    @Operation(description = "Get all post of a certain categories")
    public ResponseEntity<List<Post>> getPostByCateory(@RequestParam UUID idCategory) {
        List<Post> posts = service.getPostByCategory(idCategory);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{date}")
    @Operation(description = "Search posts by created date")
    public ResponseEntity<List<Post>> getPostsByDate(@RequestParam LocalDateTime dd) {
        List<Post> posts = service.getPostsByDate(dd);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/")
    @Operation(description = "Create post")
    public ResponseEntity<Post> create(@RequestBody PostRequest body) {
        Post post = service.create(body);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")
    @Operation(description = "Update an existing post")
    public ResponseEntity<Post> update(@PathVariable UUID id, @RequestBody PostRequest body) {
        Post post = service.update(id, body);
        return ResponseEntity.ok(post);

    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete post")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.Delete(id); // Renamed from Delete to follow Java conventions
        return ResponseEntity.ok("Success");
    }

}
