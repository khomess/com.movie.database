package com.movie.database.service.impl;

import com.movie.database.dto.StarDTO;
import com.movie.database.dto.StarResponse;
import com.movie.database.entity.Actor;
import com.movie.database.entity.Director;
import com.movie.database.entity.Producer;
import com.movie.database.entity.Writer;
import com.movie.database.repository.ActorRepository;
import com.movie.database.repository.DirectorRepository;
import com.movie.database.repository.ProducerRepository;
import com.movie.database.repository.WriterRepository;
import com.movie.database.service.StarService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StarServiceImpl implements StarService {

    private ModelMapper modelMapper;
    private ActorRepository actorRepository;
    private DirectorRepository directorRepository;
    private ProducerRepository producerRepository;
    private WriterRepository writerRepository;

    public StarServiceImpl(ModelMapper modelMapper,
                           ActorRepository actorRepository,
                           DirectorRepository directorRepository,
                           ProducerRepository producerRepository,
                           WriterRepository writerRepository) {
        this.modelMapper = modelMapper;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.producerRepository = producerRepository;
        this.writerRepository = writerRepository;
    }

    @Override
    public StarResponse getAllStars(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                                                                        : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        List<Actor> actors = actorRepository.findAll();
        List<Writer> writers = writerRepository.findAll();
        List<Producer> producers = producerRepository.findAll();
        List<Director> directors = directorRepository.findAll();

        List<StarDTO> allStars = Stream.of(actors, writers, producers, directors)
                .flatMap(Collection::stream)
                .map(star -> modelMapper.map(star, StarDTO.class))
                .toList();

        int start = (int) pageable.getOffset();

        int end = Math.min((start + pageable.getPageSize()), allStars.size());

        List<StarDTO> starContent = allStars.subList(start, end);

        Page<StarDTO> starsSorted = new PageImpl<>(starContent, pageable, allStars.size());

        List<StarDTO> stars = starsSorted.getContent();

        return StarResponse
                .builder()
                .stars(stars)
                .pageNo(starsSorted.getNumber())
                .pageSize(starsSorted.getSize())
                .totalElements(starsSorted.getTotalElements())
                .totalPages(starsSorted.getTotalPages())
                .last(starsSorted.isLast())
                .build();
    }
}
