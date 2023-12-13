package com.example.kataapiesther_nm.dto;

import com.example.kataapiesther_nm.modelo.Categories;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriesDTOConverter {
    private final ModelMapper modelMapper;
    public CategoriesDTO convertToDto(Categories categories) {
        return modelMapper.map(categories, CategoriesDTO.class);

    }
}

