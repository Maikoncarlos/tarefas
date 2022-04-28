package com.github.maikoncarlos.tarefas.exception.handler;

import com.github.maikoncarlos.tarefas.exception.NotFoundTaskException;
import com.github.maikoncarlos.tarefas.exception.StandardError;
import com.github.maikoncarlos.tarefas.exception.ValidErrors;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class TarefaExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<StandardError> handleallException(Exception ex, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError("Error to application");
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(NotFoundTaskException.class)
    public final ResponseEntity<StandardError> handleNoContentException(Exception ex, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Not value is present");
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ValidErrors> handlerException(MethodArgumentNotValidException manvException, HttpServletRequest request) {
        List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
       String field = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining("  /  "));
        String fieldMessage =  fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining("  /  "));

        ValidErrors error = new ValidErrors();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Not value is present");
        error.setMessage(manvException.toString());
        error.setPath(request.getRequestURI());
        error.setField(field);
        error.setFieldMessage(fieldMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}