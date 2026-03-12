package com.blogger.blogger_box_backend.repositories;

import com.blogger.blogger_box_backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
