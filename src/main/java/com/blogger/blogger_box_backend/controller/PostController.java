package com.blogger.blogger_box_backend.controller;

import com.blogger.blogger_box_backend.model.Post;
import com.blogger.blogger_box_backend.services.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
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

    @GetMapping("/")
    @Operation(description = "Get all posts")
    public List<Post> getPost() {
        return service.getPost();
    }

    @GetMapping("/{id}/posts")
    @Operation(description = "Get all post of a certain categories")
    public List<Post> getPostByCateory(@PathVariable UUID idCategory) {
        return service.getPostByCateory(idCategory);
    }

    @GetMapping("/{date}")
    @Operation(description = "Search posts by created date")
    public List<Post> getPostsByDate(@RequestAttribute Date dd) {
        return service.getPostsByDate(dd);
    }

    @PostMapping("/")
    @Operation(description = "Create post")
    public Post create() {
        return service.create();
    }

    @PutMapping("/{id}")
    @Operation(description = "Update an existing post")
    public Post update(@PathVariable UUID id) {
        return service.update(id);

    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete post")
    public Post Delete(@PathVariable UUID id) {
        return service.Delete(id);
    }

}
