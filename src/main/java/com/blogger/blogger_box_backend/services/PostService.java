package com.blogger.blogger_box_backend.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.blogger.blogger_box_backend.dto.PostRequest;
import com.blogger.blogger_box_backend.model.Post;

public interface PostService {

    public List<Post> getPost();

    public List<Post> getPostByCategory(UUID idCategory);

    public List<Post> getPostsByDate(LocalDateTime dd);

    public Post create(PostRequest request);

    public Post update(UUID id, PostRequest request);

    public boolean Delete(UUID id);
}
