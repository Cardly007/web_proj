package com.blogger.blogger_box_backend.dto;

import org.springframework.boot.SpringApplication;

import java.util.UUID;

public class CreateCategoryRequest {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
