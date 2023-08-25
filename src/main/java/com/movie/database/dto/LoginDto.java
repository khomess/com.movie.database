package com.movie.database.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginDto {

    @NotBlank(message = "This field is mandatory")
    String usernameOrEmail;

    @NotBlank(message = "This field is mandatory")
    String password;
}
