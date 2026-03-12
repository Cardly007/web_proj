package com.blogger.blogger_box_backend.controller;

import com.blogger.blogger_box_backend.dto.CreateCategoryRequest;
import com.blogger.blogger_box_backend.dto.PostRequest;
import com.blogger.blogger_box_backend.model.Post;
import com.blogger.blogger_box_backend.services.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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
    private final PostService postService;

    public PostController(PostService service, PostService postService) {
        this.service = service;
        this.postService = postService;
    }

    @GetMapping("/")
    @Operation(description = "Get all posts")
    public List<Post> getPost(@RequestParam(required = false) String title) {
        List<Post> posts = title == null || title.isBlank()
                ? postService.getPost()
                :postService.findAllLikeTitle(title);
        return posts;
    }

    @GetMapping("/{id}/posts")
    @Operation(description = "Get all post of a certain categories")
    public List<Post> getPostByCateory(@RequestParam UUID idCategory) {
        return service.getPostByCategory(idCategory);
    }

    @GetMapping("/{date}")
    @Operation(description = "Search posts by created date")
    public List<Post> getPostsByDate(@RequestParam LocalDateTime dd) {
        return service.getPostsByDate(dd);
    }

    @PostMapping("/")
    @Operation(description = "Create post")
    public Post create(@RequestBody PostRequest body) {
        return service.create(body);
    }

    @PutMapping("/{id}")
    @Operation(description = "Update an existing post")
    public Post update(@PathVariable UUID id, @RequestBody PostRequest body) {
        return service.update(id,  body);

    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete post")
    public boolean Delete(@PathVariable UUID id) {
        return service.Delete(id);
    }

}
