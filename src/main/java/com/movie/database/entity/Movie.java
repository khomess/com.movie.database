package com.movie.database.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document("movies")
public class Movie {

    @Id
    String id;

    @NotBlank(message = "Title is mandatory")
    @Indexed(unique = true)
    String title;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate year;

    String plot;


    List<String> directorsIds = new ArrayList<>();

    List<String> actorsIds = new ArrayList<>();

    List<String> writersIds = new ArrayList<>();

    List<String> producersIds = new ArrayList<>();

    List<String> genres = new ArrayList<>();

    @NotBlank(message = "Country name is mandatory")
    String country;

    long duration;

    @CreatedDate
    LocalDateTime createdDate;
    @LastModifiedDate
    LocalDateTime lastModifierDate;
}
