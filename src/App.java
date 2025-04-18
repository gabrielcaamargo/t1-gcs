import java.util.*;

public class App {
    Scanner in;
    CadastroFuncionarios cadastroFuncionarios;

    public App() {
        in = new Scanner(System.in);
        cadastroFuncionarios = new CadastroFuncionarios();
    }


    public void executar() {
        int op;
        do {
            do {
                menu();
                op = in.nextInt();
                in.nextLine();
            } while (op < 0 || op > 2);

            switch (op) {
                case 1:
                    cadastrarFuncionarios();
                    break;
                case 2:
                    editarFuncionario();
                    break;
            }
        } while (op != 0);
    }

    public void menu() {
        System.out.println(" @ MENU @ ");
        System.out.println(" [1] Cadastrar Funcionários ");
        System.out.println(" [2] Editar Dados Funcionario");
        System.out.println(" [0] Encerra sistema");
        System.out.print("> ");
    }

    public void cadastrarFuncionarios() {
        System.out.println("\f CADASTRO FUNCIONARIO(A)");

        String matriculaString;
        int matricula = 0;
        do {
            System.out.print("\n> Matricula do Funcionario(a): ");
            matriculaString = in.nextLine();

            if (matriculaString.startsWith("101") == false || matriculaString.matches("\\d+") == false) {
                System.out.println("> ATENÇÃO! Matrículas devem ser numericas e iniciar com 101 !");
                continue;
            }
            matricula = Integer.parseInt(matriculaString);

            if (cadastroFuncionarios.buscarFuncionarioMatricula(matricula) != null) {
                System.out.println("> Matrícula já esta em uso.");
                continue;
            }

        } while (matriculaString.startsWith("101") == false || cadastroFuncionarios.buscarFuncionarioMatricula(matricula) != null);

        System.out.print("> Nome do Funcionario(a): ");
        String nome = in.nextLine();
        System.out.print("> Email do Funcionario(a): ");
        String email = in.nextLine();

        Funcionario novoFuncionario = new Funcionario(matricula, nome, email);
        cadastroFuncionarios.cadastrarFuncionarios(novoFuncionario);
        System.out.println("\n> Cadastrado com Sucesso!");

    }

    public void editarFuncionario() {
        System.out.println("\f EDITAR FUNCIONARIO");
        System.out.print( "> Digite a matricula do funcionario: ");
        int matricula = in.nextInt();
        Funcionario f = cadastroFuncionarios.buscarFuncionarioMatricula(matricula);

        if(f != null) {
            System.out.println( "[1] Editar nome");
            System.out.println( "[2] Editar email");
            System.out.println( "[2] Cancelar");
            System.out.print("> ");
            int op = in.nextInt();

            switch(op) {
                case 1:
                    System.out.print("> Digite o nome atualizado: ");
                    String nome = in.nextLine();
                    f.setNome(nome);
                    break;
                case 2:
                    System.out.print("> Digite o email atualizado: ");
                    String email = in.nextLine();
                    f.setEmail(email);
                    break;
            }
            imprimeFuncionario(f);
        } else System.out.println("Nenhum funcionario encontrado com a matricula informada.");
    }

    public void imprimeFuncionario(Funcionario f) {
        System.out.println("\f DADOS DO FUNCIONARIO");
        System.out.println(" - Matricula: " + f.getMatricula());
        System.out.println(" - Nome: " + f.getNome());
        System.out.println(" - Email: " + f.getEmail());
    }
}
