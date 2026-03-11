package com.blogger.blogger_box_backend.services.impl;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.blogger.blogger_box_backend.model.Post;
import com.blogger.blogger_box_backend.services.PostService;

@Service
public class PostServiceImpl implements PostService {

    public List<Post> getPost() {
        return null;
    }

    public List<Post> getPostByCateory(UUID idCategory) {
        return null;
    }

    public List<Post> getPostsByDate(Date dd) {
        return null;
    }

    public Post create() {
        return null;
    }

    public Post update(UUID id) {
        return null;

    }

    public Post Delete(UUID id) {
        return null;
    }
}
