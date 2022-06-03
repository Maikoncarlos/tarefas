package com.github.maikoncarlos.tarefas.entities.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TarefaDTO {

    @NotBlank(message = "Description Value not null or is empty")
    private String description;

    @NotBlank(message = "Status Value not null or is empty")
    private String taskStatus;

}