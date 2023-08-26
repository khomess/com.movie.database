package com.movie.database.controller;

import com.movie.database.dto.DirectorDTO;
import com.movie.database.service.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stars/directors")
@Tag(description = "APIs for working with Director", name = "Director")
public class DirectorController {

    private DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Create Director")
    @PostMapping
    public ResponseEntity<DirectorDTO> createDirector(@Valid @RequestBody DirectorDTO directorDTO) {
        return new ResponseEntity<>(directorService.createDirector(directorDTO), HttpStatus.CREATED);
    }

    @Operation(description = "Retrieve Director")
    @GetMapping("/{id}")
    public ResponseEntity<DirectorDTO> getDirector(@PathVariable String id) {
        return ResponseEntity.ok(directorService.getDirectorById(id));
    }

    @Operation(description = "Retrieve all Directors")
    @GetMapping
    public ResponseEntity<List<DirectorDTO>> getAllDirectors() {
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Update Director")
    @PutMapping("/{id}")
    public ResponseEntity<DirectorDTO> updateDirector(@Valid @RequestBody DirectorDTO directorDTO, @PathVariable String id) {
        return ResponseEntity.ok(directorService.updateDirector(directorDTO, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Delete Director")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable String id) {
        directorService.deleteDirector(id);
        return ResponseEntity.ok("Director deleted successfully");
    }
}
