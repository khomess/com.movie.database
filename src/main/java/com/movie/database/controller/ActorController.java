package com.movie.database.controller;

import com.movie.database.dto.ActorDTO;
import com.movie.database.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stars/actors")
@Tag(description = "APIs for working with Actor", name = "Actor")
public class ActorController {

    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Create Actor")
    @PostMapping
    public ResponseEntity<ActorDTO> createActor(@Valid @RequestBody ActorDTO actorDTO) {
        return new ResponseEntity<>(actorService.createActor(actorDTO), HttpStatus.CREATED);
    }

    @Operation(description = "Retrieve Actor")
    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActor(@PathVariable String id) {
        return ResponseEntity.ok(actorService.getActorById(id));
    }

    @Operation(description = "Retrieve all Actors")
    @GetMapping
    public ResponseEntity<List<ActorDTO>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Update Actor")
    @PutMapping("/{id}")
    public ResponseEntity<ActorDTO> updateActor(@Valid @RequestBody ActorDTO actorDTO, @PathVariable String id) {
        return ResponseEntity.ok(actorService.updateActor(actorDTO, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "Delete Actor")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable String id) {
        actorService.deleteActor(id);
        return ResponseEntity.ok("Actor deleted successfully");
    }
}
