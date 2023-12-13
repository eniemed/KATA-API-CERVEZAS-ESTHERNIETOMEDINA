package com.example.kataapiesther_nm.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBeersDTO {

    private String name;
    private Long id_category;
    private Long id_style;
    private float abv;
    private float ibu;
    private float srm;
    private float upc;
    private String filepath;
    private String descript;
    private int add_user;

}
