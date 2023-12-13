package com.example.kataapiesther_nm.controller;

import com.example.kataapiesther_nm.dto.BeersDTO;
import com.example.kataapiesther_nm.dto.BeersDTOConverter;
import com.example.kataapiesther_nm.dto.CreateBeersDTO;
import com.example.kataapiesther_nm.dto.UpdateBeersDTO;
import com.example.kataapiesther_nm.error.BeerNotFoundException;
import com.example.kataapiesther_nm.modelo.Beers;
import com.example.kataapiesther_nm.service.BeersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BeersController {

    private final BeersService beersService;
    private final BeersDTOConverter beersDTOConverter;

    @GetMapping("/beers")
    public ResponseEntity <?> getAllBeers() {
        List <Beers> result = beersService.findAll();

        if(result.isEmpty()) {
            throw new BeerNotFoundException();
        } else {
            List<BeersDTO> dtoList = result.stream().map(beersDTOConverter::convertToDto).collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/beer/{id}")
    public ResponseEntity<?> getOneBeer(@PathVariable Long id) {
        Beers result = beersService.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
        return (result == null) ?
                ResponseEntity.notFound().build():ResponseEntity.ok(result);
    }

    @PostMapping("/beer")
    public ResponseEntity<?> newBeer(@RequestBody CreateBeersDTO newBeerData){

        return ResponseEntity.status(HttpStatus.CREATED).body(beersService.newBeers(newBeerData));
    }

    @PutMapping("/beer/{id}")
    public ResponseEntity<?> editBeer (@RequestBody UpdateBeersDTO editBeer, @PathVariable Long id){

        Beers updatedBeer = beersService.updateBeer(editBeer, id);
        if (updatedBeer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBeer);
    }

    @DeleteMapping("/beer/{id}")
    public ResponseEntity<?> deleteBeers (@PathVariable Long id){
        Beers beer = beersService.findById(id).orElse(null);
        if(beer == null) {
            return ResponseEntity.notFound().build();
        }
        beersService.delete(beer);
        return ResponseEntity.noContent().build();
    }
}
