package com.movie.database.repository;

import com.movie.database.entity.Producer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProducerRepository extends MongoRepository<Producer, String> {
}
