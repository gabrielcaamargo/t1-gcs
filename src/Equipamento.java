public class Equipamento {

    private int id;
    private String nome, descricao, dataAquisicao;
    private double valorAquisicao;
    private TipoEquipamento tipoEquipamento;

    public Equipamento(int id, String nome, String descricao, String dataAquisicao, double valorAquisicao, TipoEquipamento tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.tipoEquipamento = tipo;
    }

    public void editarDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }


    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public TipoEquipamento getTipoEquipamento() { return tipoEquipamento; }
    public double getValorAquisicao() { return valorAquisicao; }
    public String getDataAquisicao() { return dataAquisicao; }
}
