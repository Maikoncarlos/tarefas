package com.github.maikoncarlos.tarefas.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidErrors extends StandardError {

    private String field;
    private String fieldMessage;

}