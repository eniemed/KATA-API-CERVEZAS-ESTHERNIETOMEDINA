package com.example.kataapiesther_nm.dto;


import com.example.kataapiesther_nm.modelo.Beers;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeersDTOConverter {
    private final ModelMapper modelMapper;
    public BeersDTO convertToDto(Beers beers) {
        return modelMapper.map(beers, BeersDTO.class);

    }
}

