package com.example.kataapiesther_nm.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StyleNotFoundException extends RuntimeException {
    public StyleNotFoundException(){
        super("Estilos no encontrados");
    }

    public StyleNotFoundException(Long id){
        super("Estilo con id" + id + " no encontrado");
    }
}
