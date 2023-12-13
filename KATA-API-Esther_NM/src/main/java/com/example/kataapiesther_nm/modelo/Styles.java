package com.example.kataapiesther_nm.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Styles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int cat_id;

    private String style_name;

    private Date last_mod;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Categories categories;
}
