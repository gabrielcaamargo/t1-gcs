public enum EstadoManutencao {
    SOLICITADA("Solicitada"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDA_COM_SUCESSO("Concluída com sucesso"),
    CONCLUIDA_COM_FALHA("Concluída com falha"),
    CANCELADA("Cancelada");

    private final String descricao;

    private EstadoManutencao(String descricao) {
        this.descricao = descricao;
    }
}

