package com.blogger.blogger_box_backend.controller;

import com.blogger.blogger_box_backend.dto.CreateCategoryRequest;
import com.blogger.blogger_box_backend.model.Category;
import com.blogger.blogger_box_backend.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Category Apis", description = "les differents endpoint de l'api category")
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/")
    @Operation(description = "Get all categories")
    public List<Category> listCategories() {
        return service.listCategories();
    }

    @GetMapping("/{id}")
    @Operation(description = "Get category by id")
    public Category categoryById(@PathVariable UUID id) {

        return service.categoryById(id);
    }

    @PostMapping("/")
    @Operation(description = "Create a new category")
    public Category create(@RequestBody CreateCategoryRequest request) {

        return service.create(request);
    }

    @PutMapping("/{id}")
    @Operation(description = "Update an existing category")
    public Category update(@PathVariable UUID id, @RequestBody CreateCategoryRequest request) {

        return service.update(id, request);

    }

    @PatchMapping("/{id}")
    @Operation(description = "Update a sub property of an existing category")
    public Category update_sub(@PathVariable UUID id, @RequestBody CreateCategoryRequest request) {

        return service.update_sub(id, request);

    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete a category")
    public Boolean removeById(@PathVariable UUID id) {

        return service.removeById(id);

    }

}
