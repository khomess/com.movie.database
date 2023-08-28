package com.movie.database.service;

import com.movie.database.dto.StarResponse;

public interface StarService {

    StarResponse getAllStars(int pageNo, int pageSize, String sortBy, String sortDir);
}
