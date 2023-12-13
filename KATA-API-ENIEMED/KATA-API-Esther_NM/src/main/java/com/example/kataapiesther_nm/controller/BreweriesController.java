package com.example.kataapiesther_nm.controller;


import com.example.kataapiesther_nm.error.BreweryNotFoundException;
import com.example.kataapiesther_nm.error.CategoryNotFoundException;
import com.example.kataapiesther_nm.modelo.Breweries;
import com.example.kataapiesther_nm.modelo.Categories;
import com.example.kataapiesther_nm.repos.BreweriesRepo;
import com.example.kataapiesther_nm.repos.CategoriesRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kata-api")
public class BreweriesController {

    private final BreweriesRepo breweriesRepo;

    public BreweriesController(BreweriesRepo breweriesRepo) {this.breweriesRepo = breweriesRepo;}

    @GetMapping("/breweries")
    public ResponseEntity<List<?>> getAllBreweries(){
        List<Breweries> breweries = breweriesRepo.findAll();
        if(breweries.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(breweries);
        }
    }

    @GetMapping("brewerie/{id}")
    public Breweries getBreweryById(@PathVariable Long id){
        return breweriesRepo.findById(id).orElseThrow(() -> new BreweryNotFoundException(id));
    }
}
