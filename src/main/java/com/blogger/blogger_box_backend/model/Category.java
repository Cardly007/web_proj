package com.blogger.blogger_box_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @Column(name =  "id")
    private UUID id;

    @Column(name =  "name")
    private  String name;

    public Category(){}

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
