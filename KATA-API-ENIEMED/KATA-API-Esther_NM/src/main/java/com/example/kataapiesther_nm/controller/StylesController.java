package com.example.kataapiesther_nm.controller;


import com.example.kataapiesther_nm.error.CategoryNotFoundException;
import com.example.kataapiesther_nm.error.StyleNotFoundException;
import com.example.kataapiesther_nm.modelo.Categories;
import com.example.kataapiesther_nm.modelo.Styles;
import com.example.kataapiesther_nm.repos.CategoriesRepo;
import com.example.kataapiesther_nm.repos.StylesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kata-api")
public class StylesController {
    private final StylesRepo stylesRepo;

    public StylesController(StylesRepo stylesRepo) {this.stylesRepo = stylesRepo;}

    @GetMapping("/styles")
    public ResponseEntity<List<?>> getAllStyles(){
        List<Styles> styles = stylesRepo.findAll();
        if(styles.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(styles);
        }
    }

    @GetMapping("style/{id}")
    public Styles getStyleById(@PathVariable Long id){
        return stylesRepo.findById(id).orElseThrow(() -> new StyleNotFoundException(id));
    }
}

