package com.example.kataapiesther_nm.controller;

import com.example.kataapiesther_nm.dto.BreweriesDTO;
import com.example.kataapiesther_nm.dto.BreweriesDTOConverter;
import com.example.kataapiesther_nm.error.BreweryNotFoundException;
import com.example.kataapiesther_nm.modelo.Breweries;
import com.example.kataapiesther_nm.repos.BreweriesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BreweriesController {

    private final BreweriesRepo breweriesRepo;
    private final BreweriesDTOConverter breweriesDTOConverter;

    @GetMapping("/breweries")
    public ResponseEntity<?> getAllBreweries() {
        List <Breweries> result = breweriesRepo.findAll();

        if(result.isEmpty()) {
            throw new BreweryNotFoundException();
        } else {
            List<BreweriesDTO> breweriesDTOList = result.stream().map(breweriesDTOConverter::convertToDto).collect(Collectors.toList());
            return ResponseEntity.ok(breweriesDTOList);
        }
    }

    @GetMapping("/brewerie/{id}")
    public ResponseEntity<?> getOneBreweries(@PathVariable Long id) {
        Breweries brewerie = breweriesRepo.findById(id).orElseThrow(()-> new BreweryNotFoundException(id));
        return (brewerie == null) ?
                ResponseEntity.notFound().build():ResponseEntity.ok(brewerie);
    }
}
