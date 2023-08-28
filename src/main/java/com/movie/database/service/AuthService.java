package com.movie.database.service;

import com.movie.database.dto.JWTAuthResponse;
import com.movie.database.dto.LoginDto;
import com.movie.database.dto.RegisterDto;

public interface AuthService {

    JWTAuthResponse login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
