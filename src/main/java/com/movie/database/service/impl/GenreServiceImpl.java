package com.movie.database.service.impl;

import com.movie.database.configuration.exception.ResourceNotFoundException;
import com.movie.database.dto.GenreDTO;
import com.movie.database.entity.Genre;
import com.movie.database.repository.GenreRepository;
import com.movie.database.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    private ModelMapper modelMapper;
    private GenreRepository genreRepository;

    public GenreServiceImpl(ModelMapper modelMapper, GenreRepository genreRepository) {
        this.modelMapper = modelMapper;
        this.genreRepository = genreRepository;
    }

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = genreRepository.save(modelMapper.map(genreDTO, Genre.class));
        return modelMapper.map(genre, GenreDTO.class);
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres
                .stream()
                .map(genre -> modelMapper.map(genre, GenreDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GenreDTO getGenreById(String id) {
        return modelMapper
                .map(genreRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id)),
                     GenreDTO.class);
    }

    @Override
    public GenreDTO updateGenre(GenreDTO genreDTO, String id) {
        Genre genre = genreRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));

        genre.setId(id);
        genre.setName(genreDTO.getName());

        genreRepository.save(genre);

        return modelMapper.map(genre, GenreDTO.class);
    }

    @Override
    public void deleteGenre(String id) {
        genreRepository.delete(genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id)));
    }
}
