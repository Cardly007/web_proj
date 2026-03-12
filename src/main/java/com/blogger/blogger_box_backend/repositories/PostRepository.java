package com.blogger.blogger_box_backend.repositories;

import com.blogger.blogger_box_backend.model.Category;
import com.blogger.blogger_box_backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findByCategory_Id(UUID categoryId);

    @Query("""
        SELECT post
        FROM Post  post 
        WHERE UPPER(post.title) LIKE UPPER(CONCAT('%',:title,'%')) 
    """)
    List<Post> findAllLikeTitle(@Param("title") String title);
}
