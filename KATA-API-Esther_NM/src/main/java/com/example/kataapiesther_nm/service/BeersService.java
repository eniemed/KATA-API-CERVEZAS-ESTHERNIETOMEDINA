package com.example.kataapiesther_nm.service;


import com.example.kataapiesther_nm.dto.CreateBeersDTO;
import com.example.kataapiesther_nm.dto.UpdateBeersDTO;
import com.example.kataapiesther_nm.modelo.Beers;
import com.example.kataapiesther_nm.modelo.Categories;
import com.example.kataapiesther_nm.modelo.Styles;
import com.example.kataapiesther_nm.repos.BeersRepo;
import com.example.kataapiesther_nm.repos.CategoriesRepo;
import com.example.kataapiesther_nm.repos.StylesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BeersService extends BaseService<Beers, Long, BeersRepo> {

    private final BeersRepo beersRepo;
    private final CategoriesRepo categoriesRepo;
    private final StylesRepo stylesRepo;

    public Beers newBeers ( CreateBeersDTO newBeerData ){

        Beers beers = new Beers();
        Categories categories = categoriesRepo.findById(newBeerData.getId_Category()).orElse(null);
        Styles styles = stylesRepo.findById(newBeerData.getId_Category()).orElse(null);
        Date now = new Date();

        beers.setName(newBeerData.getName());
        beers.setCategories(categories);
        beers.setStyle(styles);
        beers.setAbv(newBeerData.getAbv());
        beers.setIbu(newBeerData.getIbu());
        beers.setSrm(newBeerData.getSrm());
        beers.setUpc(newBeerData.getUpc());
        beers.setFilepath(newBeerData.getFilepath());
        beers.setDescript(newBeerData.getDescript());
        beers.setAdd_user(newBeerData.getAdd_user());
        beers.setLast_mod(now);

        return save(beers);
    }

    public Beers updateBeer(UpdateBeersDTO newBeerData, Long id){
        Beers beers = beersRepo.findById(id).orElse(null);
        if(beers == null)
            return null;

        Date now = new Date();
        if (newBeerData.getName() != null) {
            beers.setName(newBeerData.getName());
        }

        if (newBeerData.getFilepath() != null) {
            beers.setFilepath(newBeerData.getFilepath());
        }

        if (newBeerData.getDescript() != null) {
            beers.setDescript(newBeerData.getDescript());
        }

        beers.setLast_mod(now);

        return save(beers);
    }
}


