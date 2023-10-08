package com.retail.test.repositories;

import com.retail.test.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByProductCategoryName(String L3ProductCategoryName);
}