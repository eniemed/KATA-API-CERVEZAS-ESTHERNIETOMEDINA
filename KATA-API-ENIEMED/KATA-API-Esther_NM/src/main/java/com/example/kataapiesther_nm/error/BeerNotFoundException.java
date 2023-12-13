package com.example.kataapiesther_nm.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeerNotFoundException extends RuntimeException {
    public BeerNotFoundException(){
        super("Cervezas no encontradas");
    }
    public BeerNotFoundException(Long id){
        super("Cerveza con id " + id + " no encontrada");
    }
}

