package com.example.kataapiesther_nm.repos;

import com.example.kataapiesther_nm.modelo.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Categories, Long> {
}
