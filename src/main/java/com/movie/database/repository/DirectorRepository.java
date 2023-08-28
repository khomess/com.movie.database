package com.movie.database.repository;

import com.movie.database.entity.Director;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DirectorRepository extends MongoRepository<Director, String> {
}
