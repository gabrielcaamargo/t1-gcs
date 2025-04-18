import java.util.*;

public class CadastroFuncionarios {
    ArrayList<Funcionario> funcionarios;

    public CadastroFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    public void cadastrarFuncionarios(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList listaFuncionarios() {
        ArrayList<Funcionario> copia = (ArrayList<Funcionario>) funcionarios.clone();
        return copia;
    }

    public Funcionario buscarFuncionarioMatricula(int matricula) {
        for (Funcionario auxiliar : funcionarios) {
            if (auxiliar.getMatricula() == matricula) {
                return auxiliar;
            }
        }
        return null;
    }
}
