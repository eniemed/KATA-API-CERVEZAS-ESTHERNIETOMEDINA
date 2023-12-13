package com.example.kataapiesther_nm.controller;


import com.example.kataapiesther_nm.dto.StylesDTO;
import com.example.kataapiesther_nm.dto.StylesDTOConverter;
import com.example.kataapiesther_nm.error.StyleNotFoundException;
import com.example.kataapiesther_nm.modelo.Styles;
import com.example.kataapiesther_nm.repos.StylesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class StylesController {

    private final StylesDTOConverter stylesDTOConverter;
    private final StylesRepo stylesRepo;

    @GetMapping("/styles")
    public ResponseEntity<?> getAllStyles() {
        List <Styles> result = stylesRepo.findAll();

        if(result.isEmpty()) {
            throw new StyleNotFoundException();
        } else {
            List<StylesDTO> dtoList = result.stream().map(stylesDTOConverter::convertToDto).collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/style/{id}")
    public ResponseEntity<?> getOneStyle(@PathVariable Long id) {
        Styles result = stylesRepo.findById(id).orElseThrow(() -> new StyleNotFoundException(id));
        return (result == null) ?
                ResponseEntity.notFound().build():ResponseEntity.ok(result);
    }
}

