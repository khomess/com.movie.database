package com.movie.database.service.impl;

import com.movie.database.configuration.exception.ResourceNotFoundException;
import com.movie.database.dto.ActorDTO;
import com.movie.database.entity.Actor;
import com.movie.database.repository.ActorRepository;
import com.movie.database.service.ActorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private ModelMapper modelMapper;
    private ActorRepository actorRepository;

    public ActorServiceImpl(ModelMapper modelMapper, ActorRepository actorRepository) {
        this.modelMapper = modelMapper;
        this.actorRepository = actorRepository;
    }

    @Override
    public ActorDTO createActor(ActorDTO actorDTO) {
        Actor actor = actorRepository.save(modelMapper.map(actorDTO, Actor.class));
        return modelMapper.map(actor, ActorDTO.class);
    }

    @Override
    public ActorDTO getActorById(String id) {
        return modelMapper
                .map(actorRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Actor", "id", id)),
                     ActorDTO.class);
    }

    @Override
    public List<ActorDTO> getAllActors() {
        List<Actor> actors = actorRepository.findAll();
        return actors
                .stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ActorDTO updateActor(ActorDTO actorDTO, String id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor", "id", id));

        actor.setId(id);
        actor.setFirstName(actorDTO.getFirstName());
        actor.setLastName(actorDTO.getLastName());
        actor.setDateOfBirth(actorDTO.getDateOfBirth());

        Actor updatedActor = actorRepository.save(actor);

        return modelMapper.map(updatedActor, ActorDTO.class);
    }

    @Override
    public void deleteActor(String id) {
        actorRepository.delete(actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor", "id", id)));
    }
}
