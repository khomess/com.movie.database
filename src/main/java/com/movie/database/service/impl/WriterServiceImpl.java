package com.movie.database.service.impl;

import com.movie.database.configuration.exception.ResourceNotFoundException;
import com.movie.database.dto.WriterDTO;
import com.movie.database.entity.Writer;
import com.movie.database.repository.WriterRepository;
import com.movie.database.service.WriterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WriterServiceImpl implements WriterService {

    private final ModelMapper modelMapper;
    private final WriterRepository writerRepository;

    public WriterServiceImpl(ModelMapper modelMapper, WriterRepository writerRepository) {
        this.modelMapper = modelMapper;
        this.writerRepository = writerRepository;
    }

    @Override
    public WriterDTO createWriter(WriterDTO writerDTO) {
        Writer writer = writerRepository.save(modelMapper.map(writerDTO, Writer.class));
        return modelMapper.map(writer, WriterDTO.class);
    }

    @Override
    public WriterDTO getWriterById(String id) {
        Writer writer = writerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Writer", "id", id));
        return modelMapper.map(writer, WriterDTO.class);
    }

    @Override
    public List<WriterDTO> getAllWriters() {
        List<Writer> writers = writerRepository.findAll();
        return writers
                .stream()
                .map(writer -> modelMapper.map(writer, WriterDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public WriterDTO updateWriter(WriterDTO writerDTO, String id) {
        Writer writer = writerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Writer", "id", id));

        writer.setId(id);
        writer.setFirstName(writerDTO.getFirstName());
        writer.setLastName(writerDTO.getLastName());
        writer.setDateOfBirth(writerDTO.getDateOfBirth());

        Writer updatedWriter = writerRepository.save(writer);

        return modelMapper.map(updatedWriter, WriterDTO.class);
    }

    @Override
    public void deleteWriter(String id) {
        writerRepository.delete(writerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Writer", "id", id)));
    }
}
