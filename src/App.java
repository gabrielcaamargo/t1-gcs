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
                    alterarFuncionairios();
                    break;
                case 3:
                    cadastroEquipamento();
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

    public void alterarFuncionairios() {
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
                        Equipamento novoEquipmaneto = new Equipamento(idEquipamento, nomeEquipamento, descricaoEquipamento, dataAquisição, custoAquisicao, enumTipo, null);
                        cadastroEquipamentos.adicionaEquipamentos(novoEquipmaneto);

                    } else if (tipoEquipamento == 2) {

                        TipoEquipamento enumTipo = TipoEquipamento.FIXO;
                        Equipamento novoEquipmaneto = new Equipamento(idEquipamento, nomeEquipamento, descricaoEquipamento, dataAquisição, custoAquisicao, enumTipo, null);
                        cadastroEquipamentos.adicionaEquipamentos(novoEquipmaneto);

                    } else {
                        System.out.println("Tipo Inválido.");
                        continue;
                    }

                    cadastraFuncionarioResponsavel(idEquipamento);
                    System.out.println("> Cadastrado com sucesso!");

                } while (tipoEquipamento < 1 || tipoEquipamento > 2);
            } else {
                System.out.println("ATENÇÃO! ID em uso.");
                continue;
            }
        } while (aux != null);
    }

    public void cadastraFuncionarioResponsavel(int idEquipamento) {
        Funcionario funcionario;
        int idFuncionario;
        int idEquipa = idEquipamento;

        do {
            System.out.println("\n> Digite o ID do funcionário responsável: ");
            idFuncionario = in.nextInt();
            funcionario = cadastroFuncionarios.buscarFuncionarioMatricula(idFuncionario);
            if(funcionario == null) {
                System.out.print("Não foi possível encontrar um funcionário com essa matrícula!");
            }
        }while(funcionario==null);

        Equipamento equipamento = cadastroEquipamentos.buscarEquipamentoId(idEquipa);

        if(equipamento != null) {
            equipamento.setFuncionario(funcionario);
            funcionario.addEquipamento(equipamento);
        }
    }
}