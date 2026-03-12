package com.blogger.blogger_box_backend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.blogger.blogger_box_backend.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import com.blogger.blogger_box_backend.dto.CreateCategoryRequest;
import com.blogger.blogger_box_backend.model.Category;
import com.blogger.blogger_box_backend.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> lst;

    private final CategoryRepository repository;

    public  CategoryServiceImpl (CategoryRepository repository)
    {
        this.repository = repository;
    }

//    public CategoryServiceImpl() {
//        lst = new ArrayList<Category>();
//        lst.add(new Category("Football"));
//        lst.add(new Category("NBA"));
//        lst.add(new Category("Poker"));
//        lst.add(new Category("Millionaire"));
//    }

    public List<Category> listCategories() {
        return repository.findAll();
    }

    public List<Category> getAllLikeName(String name){ return  repository.findAllLikeName(name);}

    public Category categoryById(UUID id) {
        return repository.findById(id).orElse(null);
    }

//    public Category create(CreateCategoryRequest request) {
//        Category n = new Category(request.getName());
//        lst.add(n);
//        return n;
//    }

    public Category create(String name) {
        Category category = new Category(name);
        return repository.save(category);
    }

    public Category create(CreateCategoryRequest request) {
        Category n = new Category(request.getName());
        return repository.save(n);
    }

    public Category updateName(UUID id, String name) {
        Category val = categoryById(id);
        if(val == null)
        {
            return null;
        }
        val.setName(name);
        return repository.save(val);
    }

    public Category update(UUID id, CreateCategoryRequest request) {

        Category val = categoryById(id);
        val.setName(request.getName());
        return val;

    }

    public Category update_sub(UUID id, CreateCategoryRequest request) {

        Category val = categoryById(id);
        val.setName(request.getName());
        return val;

    }

    public Boolean removeById(UUID id) {
        repository.deleteById(id);
        return true;

    }

}
