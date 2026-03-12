package com.blogger.blogger_box_backend.services.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.blogger.blogger_box_backend.dto.PostRequest;
import com.blogger.blogger_box_backend.model.Category;
import com.blogger.blogger_box_backend.repositories.CategoryRepository;
import com.blogger.blogger_box_backend.repositories.PostRepository;
import com.blogger.blogger_box_backend.services.CategoryService;
import org.springframework.stereotype.Service;
import com.blogger.blogger_box_backend.model.Post;
import com.blogger.blogger_box_backend.services.PostService;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    public  PostServiceImpl(PostRepository repository)
    {
        this.repository = repository;
    }

    public List<Post> getPost() {
        return repository.findAll();
    }

    public List<Post> getPostByCategory(UUID idCategory) {
        return repository.findByCategory_Id(idCategory);
    }

    public List<Post> getPostsByDate(LocalDateTime dd) {
        return null;
    } // NO EXIST

    public  List<Post> findAllLikeTitle(String title){ return  repository.findAllLikeTitle(title);}

    public Post create(PostRequest request) {
        Post p = new Post(request.tittle(),
                request.content(),
                new Timestamp(System.currentTimeMillis()).toLocalDateTime(),
                CreateCategory(request.categoryid()));

        return repository.save(p);
    }

    public Post update(UUID id, PostRequest request) {
        Post p = repository.findById(id).orElse(null);
        if(p == null) return  null;

        p.setTitle(request.tittle());
        p.setContent(request.content());
        p.setCategory(CreateCategory(request.categoryid()));
        return repository.save(p);
    }

    public boolean Delete(UUID id) {
         repository.deleteById(id);
         return  true;
    }

    public Category CreateCategory(UUID categoryId){
        if(categoryId == null) return  null;
        Category cat = new Category();
        cat.setId(categoryId);
        return  cat;
    }
}
