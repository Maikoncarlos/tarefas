package com.github.maikoncarlos.tarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserRegisteredException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserRegisteredException(String message) {
        super(message);
    }

}