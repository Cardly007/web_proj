package com.blogger.blogger_box_backend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.blogger.blogger_box_backend.dto.CreateCategoryRequest;
import com.blogger.blogger_box_backend.model.Category;
import com.blogger.blogger_box_backend.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> lst;

    public CategoryServiceImpl() {
        lst = new ArrayList<Category>();
        lst.add(new Category("Football"));
        lst.add(new Category("NBA"));
        lst.add(new Category("Poker"));
        lst.add(new Category("Millionaire"));
    }

    public List<Category> listCategories() {
        return lst;
    }

    public Category categoryById(UUID id) {
        for (Category e : lst) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public Category create(CreateCategoryRequest request) {
        Category n = new Category(request.getName());
        lst.add(n);
        return n;
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

    public Category removeById(UUID id) {
        Category val = null;
        for (Category e : lst) {
            if (e.getId().equals(id)) {
                val = e;
            }
        }

        if (val != null) {
            lst.remove(val);
            return val;
        }

        return null;

    }

}
