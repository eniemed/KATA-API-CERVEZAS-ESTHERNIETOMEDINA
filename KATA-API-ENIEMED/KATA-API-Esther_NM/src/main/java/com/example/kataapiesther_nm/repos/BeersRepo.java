package com.example.kataapiesther_nm.repos;

import com.example.kataapiesther_nm.modelo.Beers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeersRepo extends JpaRepository<Beers, Long> {
}
