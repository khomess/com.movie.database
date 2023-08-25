package com.movie.database.controller;

import com.movie.database.dto.WriterDTO;
import com.movie.database.service.WriterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stars/writers")
@Tag(description = "APIs for working with Writer", name = "Writer")
public class WriterController {

    private final WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Create Writer")
    @PostMapping
    public ResponseEntity<WriterDTO> createWriter(@Valid @RequestBody WriterDTO writerDTO) {
        return new ResponseEntity<>(writerService.createStar(writerDTO), HttpStatus.CREATED);
    }

    @Operation(description = "Retrieve Writer")
    @GetMapping("/{id}")
    public ResponseEntity<WriterDTO> getWriter(@PathVariable String id) {
        return ResponseEntity.ok(writerService.getStarById(id));
    }

    @Operation(description = "Retrieve all Writer")
    @GetMapping
    public ResponseEntity<List<WriterDTO>> getAllWriters() {
        return ResponseEntity.ok(writerService.getAllStars());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Update Writer")
    @PutMapping("/{id}")
    public ResponseEntity<WriterDTO> updateWriter(@Valid @RequestBody WriterDTO writerDTO, @PathVariable String id) {
        return ResponseEntity.ok(writerService.updateStar(writerDTO, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Delete Writer")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWriter(@PathVariable String id) {
        writerService.deleteStar(id);
        return ResponseEntity.ok("Writer deleted successfully");
    }
}
