package com.movie.database.configuration.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MovieAPIException extends RuntimeException{

    private HttpStatus httpStatus;
    private String message;

    public MovieAPIException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public MovieAPIException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }
}
