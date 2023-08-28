package com.movie.database.controller;

import com.movie.database.dto.GenreDTO;
import com.movie.database.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genres")
@Tag(description = "APIs for working with Genre", name = "Genre")
public class GenreController {

    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Create Genre")
    @PostMapping
    public ResponseEntity<GenreDTO> createGenre(@Valid @RequestBody GenreDTO genreDTO) {
        return new ResponseEntity<>(genreService.createGenre(genreDTO), HttpStatus.CREATED);
    }

    @Operation(description = "Retrieve Genre")
    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getGenre(@PathVariable String id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }

    @Operation(description = "Retrieve all Genres")
    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Update Genre")
    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> updateGenre(@Valid @RequestBody GenreDTO genreDTO, @PathVariable String id) {
        return ResponseEntity.ok(genreService.updateGenre(genreDTO, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Delete Genre")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable String id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok("Genre deleted successfully");
    }
}
