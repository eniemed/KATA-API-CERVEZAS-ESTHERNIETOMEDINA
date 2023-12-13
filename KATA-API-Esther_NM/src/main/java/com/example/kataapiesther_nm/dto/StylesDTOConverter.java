package com.example.kataapiesther_nm.dto;

import com.example.kataapiesther_nm.modelo.Styles;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StylesDTOConverter {
    private final ModelMapper modelMapper;
    public StylesDTO convertToDto(Styles styles) {
        return modelMapper.map(styles, StylesDTO.class);
    }
}

