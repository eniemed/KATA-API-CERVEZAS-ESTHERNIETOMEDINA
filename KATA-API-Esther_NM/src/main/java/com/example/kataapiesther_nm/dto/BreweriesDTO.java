package com.example.kataapiesther_nm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreweriesDTO {
    //Me parece más adecuado mostrar información más específica, en vez de todos los campos
    private long id;
    private String name;
    private String city;
    private String state;
    private String code;
    private String country;
    private String phone;
    private String descript;
}
