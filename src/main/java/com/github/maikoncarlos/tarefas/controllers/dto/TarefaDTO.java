package com.github.maikoncarlos.tarefas.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TarefaDTO {

    private String descricao;
    private String tarefaStatus;

//    public String getTarefaStatus() {
//        return TarefaStatusEnum.toEnum(this.tarefaStatus).getDescription();
//    }
//
//    public void setTarefaStatus(String tarefaStatus) {
//        this.tarefaStatus = TarefaStatusEnum.toEnum(tarefaStatus).getStatus();
//    }
}
