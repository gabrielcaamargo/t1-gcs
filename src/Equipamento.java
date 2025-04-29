public class Equipamento {

    private int id;
    private String nome, descricao, dataAquisicao;
    private double valorAquisicao;
    private TipoEquipamento tipoEquipamento;
    private Funcionario funcionario;

    public Equipamento(int id, String nome, String descricao, String dataAquisicao, double valorAquisicao, TipoEquipamento tipo, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.tipoEquipamento = tipo;
        this.funcionario = funcionario;
    }

    public void editarDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    public int getId() {
        return id;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
