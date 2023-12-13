package com.example.kataapiesther_nm.dto;

import com.example.kataapiesther_nm.modelo.Breweries;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BreweriesDTOConverter {
    private final ModelMapper modelMapper;
    public BreweriesDTO convertToDto(Breweries brewerie) {
        return modelMapper.map(brewerie, BreweriesDTO.class);
    }

}

