package com.movie.database.service;

import com.movie.database.dto.ProducerDTO;

import java.util.List;

public interface ProducerService {

    ProducerDTO createProducer(ProducerDTO producerDTO);

    ProducerDTO getProducerById(String id);

    List<ProducerDTO> getAllProducers();

    ProducerDTO updateProducer(ProducerDTO producerDTO, String id);

    void deleteProducer(String id);
}
