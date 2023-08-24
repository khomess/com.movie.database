package com.movie.database.service;

import com.movie.database.dto.WriterDTO;

import java.util.List;

public interface WriterService {

    WriterDTO createWriter(WriterDTO writerDTO);

    WriterDTO getWriterById(String id);

    List<WriterDTO> getAllWriters();

    WriterDTO updateWriter(WriterDTO writerDTO, String id);

    void deleteWriter(String id);
}
