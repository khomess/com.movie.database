package com.movie.database.controller;

import com.movie.database.dto.ProducerDTO;
import com.movie.database.service.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stars/producers")
@Tag(description = "APIs for working with Producer", name = "Producer")
public class ProducerController {

    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Create Producer")
    @PostMapping
    public ResponseEntity<ProducerDTO> createProducer(@Valid @RequestBody ProducerDTO producerDTO) {
        return new ResponseEntity<>(producerService.createProducer(producerDTO), HttpStatus.CREATED);
    }

    @Operation(description = "Retrieve Producer")
    @GetMapping("/{id}")
    public ResponseEntity<ProducerDTO> getProducer(@PathVariable String id) {
        return ResponseEntity.ok(producerService.getProducerById(id));
    }

    @Operation(description = "Retrieve all Producers")
    @GetMapping
    public ResponseEntity<List<ProducerDTO>> getAllProducers() {
        return ResponseEntity.ok(producerService.getAllProducers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Update Producer")
    @PutMapping("/{id}")
    public ResponseEntity<ProducerDTO> updateProducer(@Valid @RequestBody ProducerDTO producerDTO, @PathVariable String id) {
        return ResponseEntity.ok(producerService.updateProducer(producerDTO, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Delete Producer")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducer(@PathVariable String id) {
        producerService.deleteProducer(id);
        return ResponseEntity.ok("Producer deleted successfully");
    }
}
