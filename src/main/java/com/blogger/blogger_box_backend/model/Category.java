package com.blogger.blogger_box_backend.model;

import java.util.UUID;

public class Category {
    private UUID id;
    private  String name;

    private Category(){}

    public   Category(String name)
    {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
