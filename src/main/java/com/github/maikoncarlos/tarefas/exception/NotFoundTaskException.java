package com.github.maikoncarlos.tarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundTaskException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundTaskException(String message) {
        super(message);
    }
}