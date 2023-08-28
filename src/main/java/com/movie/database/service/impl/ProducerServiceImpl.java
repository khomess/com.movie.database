package com.movie.database.service.impl;

import com.movie.database.configuration.exception.ResourceNotFoundException;
import com.movie.database.dto.ProducerDTO;
import com.movie.database.entity.Actor;
import com.movie.database.entity.Producer;
import com.movie.database.repository.ProducerRepository;
import com.movie.database.service.ProducerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProducerServiceImpl implements ProducerService {

    private ModelMapper modelMapper;
    private ProducerRepository producerRepository;

    public ProducerServiceImpl(ModelMapper modelMapper, ProducerRepository producerRepository) {
        this.modelMapper = modelMapper;
        this.producerRepository = producerRepository;
    }

    @Override
    public ProducerDTO createProducer(ProducerDTO producerDTO) {
        Producer producer = producerRepository.save(modelMapper.map(producerDTO, Producer.class));
        return modelMapper.map(producer, ProducerDTO.class);
    }

    @Override
    public ProducerDTO getProducerById(String id) {
        return modelMapper.map(
                producerRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Producer", "id", id)), ProducerDTO.class);
    }

    @Override
    public List<ProducerDTO> getAllProducers() {
        List<Producer> producers = producerRepository.findAll();
        return producers
                .stream()
                .map(producer -> modelMapper.map(producer, ProducerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProducerDTO updateProducer(ProducerDTO producerDTO, String id) {
        Producer producer = producerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producer", "id", id));

        producer.setId(id);
        producer.setFirstName(producerDTO.getFirstName());
        producer.setLastName(producerDTO.getLastName());
        producer.setDateOfBirth(producerDTO.getDateOfBirth());

        Producer updatedProducer = producerRepository.save(producer);

        return modelMapper.map(updatedProducer, ProducerDTO.class);
    }

    @Override
    public void deleteProducer(String id) {
        producerRepository.delete(producerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producer", "id", id)));
    }
}
