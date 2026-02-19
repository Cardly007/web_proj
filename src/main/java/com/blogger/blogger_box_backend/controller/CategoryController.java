package com.blogger.blogger_box_backend.controller;

import com.blogger.blogger_box_backend.dto.CreateCategoryRequest;
import com.blogger.blogger_box_backend.model.Category;
import io.swagger.v3.oas.annotations.links.Link;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private List<Category> lst;

    public CategoryController(){
        lst  = new ArrayList<Category>();
        lst.add(new Category("Football"));
        lst.add(new Category("NBA"));
        lst.add(new Category("Poker"));
        lst.add(new Category("Millionaire"));
    }

    @GetMapping("/")
    public List<Category> listCategories() {
        return lst;
    }

    @GetMapping("/{id}")
    public Category categoryById(@PathVariable UUID id) {
       for( Category e : lst){
           if (e.getId().equals(id)){
               return e;
           }
       }
        return null;
    }

    @PostMapping("/")
    public Category create(@RequestBody CreateCategoryRequest request) {
        Category n = new Category(request.getName());
        lst.add(n);
        return n;
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable UUID id, @RequestBody CreateCategoryRequest request) {

        Category val = categoryById(id);
        val.setName(request.getName());
        return val;

    }

    @DeleteMapping("/{id}")
    public Category removeById(@PathVariable UUID id){
        Category val;
        for( Category e : lst){
            if (e.getId().equals(id)){
                val = e;
            }
        }

        lst.remove(val);

    }


}
