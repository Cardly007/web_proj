package com.blogger.blogger_box_backend.services;

import java.util.List;
import java.util.UUID;

import com.blogger.blogger_box_backend.dto.CreateCategoryRequest;
import com.blogger.blogger_box_backend.model.Category;

public interface CategoryService {

    public List<Category> listCategories();

    public Category categoryById(UUID id);

    public Category create(CreateCategoryRequest request);

    public Category update(UUID id, CreateCategoryRequest request);

    public Category update_sub(UUID id, CreateCategoryRequest request);

    public Boolean removeById(UUID id);

    public List<Category> getAllLikeName(String name);
}
