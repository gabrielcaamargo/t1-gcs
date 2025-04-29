import java.util.ArrayList;

public class Funcionario {

    private int matricula;
    private String nome;
    private String email;
    private ArrayList<Equipamento> equipamentos;

    public Funcionario(int matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        equipamentos = new ArrayList<>();
    }

    public void editarNomes(String novoNome) {
        this.nome = novoNome;
    }

    public void editarEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public boolean addEquipamento(Equipamento equipamento) {
        for(Equipamento equip : equipamentos) {
            if(equip.getId() == equipamento.getId()) {
                return false;
            }
        }
        equipamentos.add(equipamento);
        return true;
    }

    public ArrayList<Equipamento> getEquipamentos(){
        return equipamentos;
    }

    public String getEmail() {
        return email;
    }
}
