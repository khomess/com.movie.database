package com.movie.database.controller;

import com.movie.database.dto.MovieDTO;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public MovieDTO createMovie(@Valid @RequestBody MovieDTO movieDTO) {
        return movieDTO;
    }
}
