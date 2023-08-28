package com.movie.database.service;

import com.movie.database.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    GenreDTO createGenre(GenreDTO genreDTO);

    List<GenreDTO> getAllGenres();

    GenreDTO getGenreById(String id);

    GenreDTO updateGenre(GenreDTO genreDTO, String id);

    void deleteGenre(String id);
}
