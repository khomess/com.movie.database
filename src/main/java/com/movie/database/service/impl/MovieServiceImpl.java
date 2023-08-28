package com.movie.database.service.impl;

import com.movie.database.dto.MovieDTO;
import com.movie.database.entity.Movie;
import com.movie.database.repository.MovieRepository;
import com.movie.database.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private ModelMapper modelMapper;
    private MovieRepository movieRepository;

    public MovieServiceImpl(ModelMapper modelMapper, MovieRepository movieRepository) {
        this.modelMapper = modelMapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        System.out.println(movieDTO);
        Movie movie = movieRepository.save(modelMapper.map(movieDTO, Movie.class));
        System.out.println(movieDTO.getDirectorsIds());
//        movie.setActorsIds(movieDTO.getActorsIds());
//        movie.setWritersIds(movieDTO.getWritersIds());
//        movie.setProducersIds(movieDTO.getProducersIds());
//        movie.setGenresIds(movieDTO.getGenresIds());
//        System.out.println(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }
}
