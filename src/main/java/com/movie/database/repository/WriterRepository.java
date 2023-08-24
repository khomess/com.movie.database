package com.movie.database.repository;

import com.movie.database.entity.Writer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WriterRepository extends MongoRepository<Writer, String> {
}
