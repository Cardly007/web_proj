package com.blogger.blogger_box_backend.controller;

import com.blogger.blogger_box_backend.dto.CreateCategoryRequest;
import com.blogger.blogger_box_backend.model.Category;
import com.blogger.blogger_box_backend.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Category Apis", description = "les differents endpoint de l'api category")
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;
    private final CategoryService categoryService;

    public CategoryController(CategoryService service, CategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    @Operation(description = "Get all categories")
    public ResponseEntity<List<Category>> listCategories(@RequestParam(required = false) String name) {
        List<Category> categories = name == null || name.isBlank()
                ? categoryService.listCategories()
                : categoryService.getAllLikeName(name);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @Operation(description = "Get category by id")
    public ResponseEntity<Category> categoryById(@PathVariable UUID id) throws CategoryNotFoundByIdException {

        Category category = service.categoryById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/")
    @Operation(description = "Create a new category")
    public ResponseEntity<Category> create(@RequestBody CreateCategoryRequest request) {
        Category category = service.create(request);
        return ResponseEntity
                .created(URI.create("v1/categories/" + category.getId()))
                .body(category);
    }

    @PutMapping("/{id}")
    @Operation(description = "Update an existing category")
    public ResponseEntity<Category> update(@PathVariable UUID id, @RequestBody CreateCategoryRequest request) {
        Category category = service.update(id, request);
        return ResponseEntity.ok(category);
    }

    @PatchMapping("/{id}")
    @Operation(description = "Update a sub property of an existing category")
    public ResponseEntity<Category> update_sub(@PathVariable UUID id, @RequestBody CreateCategoryRequest request) {

        Category category = service.update_sub(id, request);
        return ResponseEntity.ok(category);

    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete a category")
    public ResponseEntity<String> removeById(@PathVariable UUID id) {

        service.removeById(id);
        return ResponseEntity
                .status(200)
                .body("Succes");

    }

}
