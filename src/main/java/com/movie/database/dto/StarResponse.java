package com.movie.database.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StarResponse {
    List<StarDTO> stars;
    int pageNo;
    int pageSize;
    long totalElements;
    int totalPages;
    boolean last;
}
