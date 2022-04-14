package com.github.maikoncarlos.tarefas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class TarefaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handlerAnyException(Exception e, WebRequest request){
        String descricaoError = e.getLocalizedMessage();
        if(descricaoError == null) descricaoError = e.toString();
        ErrorMsg errorMsg = new ErrorMsg(new Date(), descricaoError);
        return new ResponseEntity<>(errorMsg, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}