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

    public List<Funcionario> buscarFuncionarioNome(String nome) {
        List<Funcionario> resultado = new ArrayList<>();
        if (nome.length() < 3) {
            return resultado;
        }
        String prefixo = nome.substring(0, 3);
        for (Funcionario auxiliar : funcionarios) {
            if (auxiliar.getNome().startsWith(prefixo)) {
                resultado.add(auxiliar);
            }
        }
        return resultado;
    }

    public boolean existemFuncionarios() {
        return !funcionarios.isEmpty();
    }
}
