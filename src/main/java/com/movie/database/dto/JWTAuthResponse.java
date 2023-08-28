package com.movie.database.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JWTAuthResponse {
    String accessToken;
    String tokenType = "Bearer";
}
