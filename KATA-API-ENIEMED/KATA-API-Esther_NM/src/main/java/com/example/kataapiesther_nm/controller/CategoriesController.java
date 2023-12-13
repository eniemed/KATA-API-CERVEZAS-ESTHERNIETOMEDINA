package com.example.kataapiesther_nm.controller;

import com.example.kataapiesther_nm.error.BeerNotFoundException;
import com.example.kataapiesther_nm.error.CategoryNotFoundException;
import com.example.kataapiesther_nm.modelo.Beers;
import com.example.kataapiesther_nm.modelo.Categories;

import com.example.kataapiesther_nm.repos.CategoriesRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kata-api")
public class CategoriesController {
   private final CategoriesRepo categoriesRepo;

   public CategoriesController(CategoriesRepo categoriesRepo) {this.categoriesRepo = categoriesRepo;}

    @GetMapping("/categories")
    public ResponseEntity<List<?>> getAllCategories(){
        List<Categories> categories = categoriesRepo.findAll();
        if(categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(categories);
        }
    }

    @GetMapping("categorie/{id}")
    public Categories getCategoryById(@PathVariable Long id){
        return categoriesRepo.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }
}

