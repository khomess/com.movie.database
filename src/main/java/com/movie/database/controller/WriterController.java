package com.movie.database.controller;

import com.movie.database.dto.WriterDTO;
import com.movie.database.service.WriterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stars/writers")
public class WriterController {

    private final WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @PostMapping
    public ResponseEntity<WriterDTO> createWriter(@Valid @RequestBody WriterDTO writerDTO) {
        return new ResponseEntity<>(writerService.createWriter(writerDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WriterDTO> getWriter(@PathVariable String id) {
        return ResponseEntity.ok(writerService.getWriterById(id));
    }

    @GetMapping
    public ResponseEntity<List<WriterDTO>> getAllWriters() {
        return ResponseEntity.ok(writerService.getAllWriters());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WriterDTO> updateWriter(@Valid @RequestBody WriterDTO writerDTO, @PathVariable String id) {
        return ResponseEntity.ok(writerService.updateWriter(writerDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWriter(@PathVariable String id) {
        writerService.deleteWriter(id);
        return ResponseEntity.ok("Writer deleted successfully");
    }
}
