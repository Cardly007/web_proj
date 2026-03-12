package com.blogger.blogger_box_backend.repositories;

import com.blogger.blogger_box_backend.model.Category;
import com.blogger.blogger_box_backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findByCategory_Id(UUID categoryId);
}
