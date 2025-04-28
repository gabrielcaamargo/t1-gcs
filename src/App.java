import java.util.*;

public class App {
    Scanner in;
    CadastroFuncionarios cadastroFuncionarios;
    CadastroEquipamentos cadastroEquipamentos;

    public App() {
        in = new Scanner(System.in);
        cadastroFuncionarios = new CadastroFuncionarios();
        cadastroEquipamentos = new CadastroEquipamentos();
    }


    public void executar() {
        int op;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();

            switch (op) {
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    cadastrarFuncionarios();
                    break;
                case 2:
                    editarFuncionario();
                    break;
                case 3:
                    cadastroEquipamento();
                    break;
                case 4:
                    procurarFuncionarioPeloNome();
                    break;
                default:
                    System.out.println("> Opção inválida!");
                    break;
            }
        } while (op != 0);
    }

    public void menu() {
        System.out.println("\n @ MENU @ ");
        System.out.println(" [1] Cadastrar Funcionários ");
        System.out.println(" [2] Editar Dados Funcionario");
        System.out.println(" [3] Cadastrar Equipamento");
        System.out.println(" [4] Buscar Funcionario pelo Nome");
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

            if (!matriculaString.startsWith("101") || !matriculaString.matches("\\d+")) {
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

    public void procurarFuncionarioPeloNome(){
        System.out.println("Digite o nome: ");
        String nome = in.nextLine();
            List<Funcionario> encontrados = cadastroFuncionarios.buscarFuncionarioNome(nome);
            // Verifica se o funcionário foi encontrado
            if(!encontrados.isEmpty()) { 
                System.out.println("Funcionário(s) encontrado(s): ");
                for (Funcionario encontrado : encontrados){
                    System.out.println("Matrícula: " + encontrado.getMatricula());
                    System.out.println("Nome: " + encontrado.getNome());                    
                    System.out.println("Email: " + encontrado.getEmail());
                    System.out.println();
                }
            } 
            else
                System.out.println("Funcionário não encontrado.");   
    }

    public void cadastroEquipamento() {
        System.out.println("\f CADASTRO EQUIPAMENTO");

        Equipamento aux;
        do {
            System.out.print("> Digite o ID ÚNICO do equipamento:");
            int idEquipamento = in.nextInt();
            in.nextLine();
            aux = cadastroEquipamentos.buscarEquipamentoId(idEquipamento);

            if (aux == null) {

                System.out.print("> Nome do Equipamento: ");
                String nomeEquipamento = in.nextLine();

                System.out.print("> Descricao do Equipamento: ");
                String descricaoEquipamento = in.nextLine();

                System.out.print("> Data de aquisição: ");
                String dataAquisição = in.nextLine();

                System.out.print("> Custo da Aquisição: ");
                double custoAquisicao = in.nextDouble();

                int tipoEquipamento;
                do {
                    System.out.println("\n> Tipo de Equipamento");
                    System.out.println("[1] Móvel");
                    System.out.println("[2] Fixo");
                    System.out.print("> ");
                    tipoEquipamento = in.nextInt();

                    if (tipoEquipamento == 1) {

                        TipoEquipamento enumTipo = TipoEquipamento.MOVEL;
                        Equipamento novoEquipmaneto = new Equipamento(idEquipamento, nomeEquipamento, descricaoEquipamento, dataAquisição, custoAquisicao, enumTipo);
                        cadastroEquipamentos.adicionaEquipamentos(novoEquipmaneto);
                        System.out.println("> Cadastrado com sucesso!");

                    } else if (tipoEquipamento == 2) {

                        TipoEquipamento enumTipo = TipoEquipamento.FIXO;
                        Equipamento novoEquipmaneto = new Equipamento(idEquipamento, nomeEquipamento, descricaoEquipamento, dataAquisição, custoAquisicao, enumTipo);
                        cadastroEquipamentos.adicionaEquipamentos(novoEquipmaneto);
                        System.out.println("> Cadastrado com sucesso!");

                    } else {
                        System.out.println("Tipo Inválido.");
                        continue;
                    }

                } while (tipoEquipamento < 1 || tipoEquipamento > 2);
            } else {
                System.out.println("ATENÇÃO! ID em uso.");
                continue;
            }
        } while (aux != null);
        
    }

    public void editarFuncionario() {
        System.out.println("\f EDITAR FUNCIONARIO");
        System.out.print( "> Digite a matricula do funcionario: ");
        int matricula = in.nextInt();
        Funcionario f = cadastroFuncionarios.buscarFuncionarioMatricula(matricula);

        if(f != null) {
            System.out.println( "[1] Editar nome");
            System.out.println( "[2] Editar email");
            System.out.println( "[3] Cancelar");
            System.out.print("> ");
            int op = in.nextInt();
            in.nextLine();
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
                case 3:
                    System.out.println("Operacao cancelada.");
                    break;
                default:
                    System.out.println("Opcao invalida, cancelando operacao.");
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
