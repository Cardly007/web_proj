package com.blogger.blogger_box_backend.services;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.blogger.blogger_box_backend.model.Post;

public interface PostService {

    public List<Post> getPost();

    public List<Post> getPostByCateory(UUID idCategory);

    public List<Post> getPostsByDate(Date dd);

    public Post create();

    public Post update(UUID id);

    public Post Delete(UUID id);
}
