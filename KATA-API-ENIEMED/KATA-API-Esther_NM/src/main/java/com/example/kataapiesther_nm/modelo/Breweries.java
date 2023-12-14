package com.example.kataapiesther_nm.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Breweries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String code;

    private String country;

    private String phone;

    private String website;

    private String filepath;

    private String descript;

    private int add_user;

    private Date last_mod;

}
