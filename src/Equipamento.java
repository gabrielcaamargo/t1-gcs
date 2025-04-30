public class Equipamento {

    private int id;
    private String nome, descricao, dataAquisicao;
    private double valorAquisicao;
    private TipoEquipamento tipoEquipamento;
    private boolean disponivel;
    private String motivoIndisponibilidade;
    private Funcionario funcionario;

    public Equipamento(int id, String nome, String descricao, String dataAquisicao, double valorAquisicao, TipoEquipamento tipo, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.tipoEquipamento = tipo;
        this.disponivel = true;
        this.motivoIndisponibilidade = null;
        this.funcionario = funcionario;
    }

    public void editarDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    public int getId() {
        return id;
    }

    public boolean equipamentoEstaDisponivel() {
        return this.disponivel;
    }

    public void indisponibilizarEquipamento(String motivo) {
        this.disponivel = false;
        this.motivoIndisponibilidade = motivo;
    }

    public void disponibilizarEquipamento() {
        this.disponivel = true;
        this.motivoIndisponibilidade = null;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
