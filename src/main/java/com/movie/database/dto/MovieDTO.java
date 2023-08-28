package com.movie.database.dto;

import com.movie.database.entity.Actor;
import com.movie.database.entity.Director;
import com.movie.database.entity.Genre;
import com.movie.database.entity.Writer;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieDTO {

    String id;

    @NotBlank(message = "Title is mandatory")
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
}
