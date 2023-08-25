package com.movie.database.service;

import com.movie.database.dto.WriterDTO;

import java.util.List;

public interface WriterService {

    WriterDTO createStar(WriterDTO writerDTO);

    WriterDTO getStarById(String id);

    List<WriterDTO> getAllStars();

    WriterDTO updateStar(WriterDTO writerDTO, String id);

    void deleteStar(String id);
}
