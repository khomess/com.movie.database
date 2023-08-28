package com.movie.database.service;

import com.movie.database.dto.DirectorDTO;

import java.util.List;

public interface DirectorService {

    DirectorDTO createDirector(DirectorDTO directorDTO);

    DirectorDTO getDirectorById(String id);

    List<DirectorDTO> getAllDirectors();

    DirectorDTO updateDirector(DirectorDTO directorDTO, String id);

    void deleteDirector(String id);
}
