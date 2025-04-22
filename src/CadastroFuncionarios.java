import java.util.*;

public class CadastroFuncionarios {
    ArrayList<Funcionario> funcionarios;

    public CadastroFuncionarios() {
        funcionarios = new ArrayList<Funcionario>();
    }

    public void cadastrarFuncionarios(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList<Funcionario> listaFuncionarios() {
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
