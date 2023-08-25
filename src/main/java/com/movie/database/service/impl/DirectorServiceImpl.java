package com.movie.database.service.impl;

import com.movie.database.configuration.exception.ResourceNotFoundException;
import com.movie.database.dto.DirectorDTO;
import com.movie.database.dto.WriterDTO;
import com.movie.database.entity.Director;
import com.movie.database.entity.Writer;
import com.movie.database.repository.DirectorRepository;
import com.movie.database.service.DirectorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorServiceImpl implements DirectorService {

    private ModelMapper modelMapper;
    private DirectorRepository directorRepository;

    public DirectorServiceImpl(ModelMapper modelMapper, DirectorRepository directorRepository) {
        this.modelMapper = modelMapper;
        this.directorRepository = directorRepository;
    }

    @Override
    public DirectorDTO createDirector(DirectorDTO directorDTO) {
        Director director = directorRepository.save(modelMapper.map(directorDTO, Director.class));
        return modelMapper.map(director, DirectorDTO.class);
    }

    @Override
    public DirectorDTO getDirectorById(String id) {
        return modelMapper
                .map(directorRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Director", "id", id)),
                     DirectorDTO.class);
    }

    @Override
    public List<DirectorDTO> getAllDirectors() {
        List<Director> directors = directorRepository.findAll();
        return directors
                .stream()
                .map(director -> modelMapper.map(director, DirectorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DirectorDTO updateDirector(DirectorDTO directorDTO, String id) {
        Director director = directorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Director", "id", id));

        director.setId(id);
        director.setFirstName(directorDTO.getFirstName());
        director.setLastName(directorDTO.getLastName());
        director.setDateOfBirth(directorDTO.getDateOfBirth());

        Director updatedDirector = directorRepository.save(director);

        return modelMapper.map(updatedDirector, DirectorDTO.class);
    }

    @Override
    public void deleteDirector(String id) {
        directorRepository.delete(directorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Director", "id", id)));
    }
}
