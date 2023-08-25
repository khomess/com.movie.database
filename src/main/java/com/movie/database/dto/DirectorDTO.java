package com.movie.database.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DirectorDTO {

    String id;

    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, message = "First name should have at least 2 characters")
    String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, message = "Last name should have at least 2 characters")
    String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dateOfBirth;
}
