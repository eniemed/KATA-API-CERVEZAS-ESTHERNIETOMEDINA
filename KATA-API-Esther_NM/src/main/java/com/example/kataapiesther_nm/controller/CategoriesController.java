package com.example.kataapiesther_nm.controller;


import com.example.kataapiesther_nm.dto.CategoriesDTO;
import com.example.kataapiesther_nm.dto.CategoriesDTOConverter;
import com.example.kataapiesther_nm.error.CategoryNotFoundException;
import com.example.kataapiesther_nm.modelo.Categories;
import com.example.kataapiesther_nm.repos.CategoriesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesRepo categoriesRepo;
    private final CategoriesDTOConverter categoriesDTOConverter;

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        List <Categories> result = categoriesRepo.findAll();

        if(result.isEmpty()) {
            throw new CategoryNotFoundException();
        } else {
            List<CategoriesDTO> dtoList = result.stream().map(categoriesDTOConverter::convertToDto).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getOneCategorie(@PathVariable Long id) {
        Categories result = categoriesRepo.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        return (result == null) ?
                ResponseEntity.notFound().build():ResponseEntity.ok(result);
    }
}

