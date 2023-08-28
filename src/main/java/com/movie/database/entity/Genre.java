package com.movie.database.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document("genres")
public class Genre {

    @Id
    String id;

    @NotBlank(message = "Name of genre is mandatory")
    @Size(min = 2, message = "Name of genre should have at least 2 characters")
    String name;

    @CreatedDate
    LocalDateTime createdDate;
    @LastModifiedDate
    LocalDateTime lastModifierDate;
}
