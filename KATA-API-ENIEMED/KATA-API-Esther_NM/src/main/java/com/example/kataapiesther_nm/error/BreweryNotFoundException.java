package com.example.kataapiesther_nm.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BreweryNotFoundException extends RuntimeException {
    public BreweryNotFoundException(){
        super("Cervecerías no encontradas");
    }
    public BreweryNotFoundException(Long id){
        super("Cervecería con id " + id + " no encontrada");
    }
}

