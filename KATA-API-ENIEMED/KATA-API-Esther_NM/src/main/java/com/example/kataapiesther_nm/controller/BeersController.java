package com.example.kataapiesther_nm.controller;

import com.example.kataapiesther_nm.error.BeerNotFoundException;
import com.example.kataapiesther_nm.modelo.Beers;
import com.example.kataapiesther_nm.repos.BeersRepo;

import com.example.kataapiesther_nm.repos.BreweriesRepo;
import com.example.kataapiesther_nm.repos.CategoriesRepo;
import com.example.kataapiesther_nm.repos.StylesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kata-api")
public class BeersController {

    private final BeersRepo beersRepo;
    public BeersController(BeersRepo beersRepo) {this.beersRepo = beersRepo;}

    @GetMapping("/beers")
    public ResponseEntity<List<Beers>> getAllBeers(){
        List<Beers> beers = beersRepo.findAll();
        if(beers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(beers);
        }
    }

    @GetMapping("beer/{id}")
    public Beers getBeerById(@PathVariable Long id){
        return beersRepo.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
    }

    @DeleteMapping("/beer/{id}")
    public ResponseEntity<Beers> deleteBeerById(@PathVariable Long id){
        Beers beer = beersRepo.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
        beersRepo.delete(beer);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/beer")
    public ResponseEntity<Beers> createBeer(@RequestBody Beers beer) {
        Beers savedBeer = beersRepo.save(beer);
        return ResponseEntity.ok(savedBeer);
    }

    @PutMapping("/beer/{id}")
    public Beers updateBeer(@PathVariable Long id, @RequestBody Beers updatedBeer) {
        updatedBeer.setId(id);
        return beersRepo.save(updatedBeer);
    }
}
