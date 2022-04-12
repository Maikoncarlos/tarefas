package com.github.maikoncarlos.tarefas.enuns;

public enum TarefaStatusEnum {

    PENDENTE("P", "pendente"),
    EM_ANDAMENTO("E", "em_andamento"),
    CANCELADO("C", "cancelado"),
    FINALIZADO("F", "finalizado");

    private String status;
    private String description;

    TarefaStatusEnum(String status, String description) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDescription() {
        return description;
    }

    public static TarefaStatusEnum toEnum(String status){
        for(TarefaStatusEnum tar : TarefaStatusEnum.values()){
            if (status.equals(tar.getStatus())){
                return tar;
            }
        }
        throw new IllegalArgumentException("status inválido");
    }

}