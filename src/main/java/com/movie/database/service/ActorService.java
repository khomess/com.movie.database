package com.movie.database.service;

import com.movie.database.dto.ActorDTO;

import java.util.List;

public interface ActorService {

    ActorDTO createActor(ActorDTO actorDTO);

    ActorDTO getActorById(String id);

    List<ActorDTO> getAllActors();

    ActorDTO updateActor(ActorDTO actorDTO, String id);

    void deleteActor(String id);
}
