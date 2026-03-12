package com.blogger.blogger_box_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Post")
public class Post {

    @Id
    @Column(name =  "id")
    private UUID id;

    @Column(name =  "title")
    private  String title;

    @Column(name =  "content")
    private  String content;

    @Column(name =  "created_date")
    @JsonFormat(pattern = "yyyy-mm-dd-hh:mn:ss")
    private LocalDateTime created_date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private  Category category;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
