import java.util.*;

public class App {
    Scanner in;
    CadastroFuncionarios cadastroFuncionarios;
    CadastroEquipamentos cadastroEquipamentos;

    public App() {
        in = new Scanner(System.in);
        cadastroFuncionarios = new CadastroFuncionarios();
        cadastroEquipamentos = new CadastroEquipamentos();
        cadastroInicialDeInformacoes();
    }

    public void cadastroInicialDeInformacoes() {
        Funcionario nFuncionario1 = new Funcionario(1010, "Daniel", "Daniel@gmail");
        Funcionario nFuncionario2 = new Funcionario(1011, "Gabriel", "Gabriel@gmail");
        Funcionario nFuncionario3 = new Funcionario(1012, "Bryan", "Bryan@gmail");
        Funcionario nFuncionario4 = new Funcionario(1013, "Rafael", "Guilherme@gmail");
        Funcionario nFuncionario5 = new Funcionario(1014, "Matheus", "Matheus@gmail");

        Equipamento nEquipamento1 = new Equipamento(1, "Celular", "Iphone", "30/04/2025", 5000, TipoEquipamento.MOVEL,
                nFuncionario1);
        Equipamento nEquipamento2 = new Equipamento(2, "Notebook", "Notebook Acer", "01/05/2025", 6000,
                TipoEquipamento.MOVEL, nFuncionario2);
        Equipamento nEquipamento3 = new Equipamento(3, "Celular", "Samsung", "01/05/2025", 3000, TipoEquipamento.MOVEL,
                nFuncionario3);
        Equipamento nEquipamento4 = new Equipamento(4, "PC", "Computador CPU", "02/05/2025", 9000, TipoEquipamento.FIXO,
                nFuncionario4);
        Equipamento nEquipamento5 = new Equipamento(5, "Telefone Fixo", "Telefone Fixo", "02/05/2025", 300,
                TipoEquipamento.FIXO, nFuncionario5);

        nFuncionario1.addEquipamento(nEquipamento1);
        nFuncionario2.addEquipamento(nEquipamento2);
        nFuncionario3.addEquipamento(nEquipamento3);
        nFuncionario4.addEquipamento(nEquipamento4);
        nFuncionario4.addEquipamento(nEquipamento5);

        cadastroEquipamentos.adicionaEquipamentos(nEquipamento1);
        cadastroEquipamentos.adicionaEquipamentos(nEquipamento2);
        cadastroEquipamentos.adicionaEquipamentos(nEquipamento3);
        cadastroEquipamentos.adicionaEquipamentos(nEquipamento4);
        cadastroEquipamentos.adicionaEquipamentos(nEquipamento5);

        cadastroFuncionarios.cadastrarFuncionarios(nFuncionario1);
        cadastroFuncionarios.cadastrarFuncionarios(nFuncionario2);
        cadastroFuncionarios.cadastrarFuncionarios(nFuncionario3);
        cadastroFuncionarios.cadastrarFuncionarios(nFuncionario4);
        cadastroFuncionarios.cadastrarFuncionarios(nFuncionario5);
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
                case 5:
                    alterarSituacaoEquipamento();
                    break;
                case 6:
                    alterarResponsavelEquipamento();
                case 7:
                    listarFuncionarios();
                    break;
                case 8:
                    pesquisaEquipamento();
                    break;
                case 9:
                    editarEquipamento();
                    break;
                case 10:
                    listarEquipamentosAntigos();
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
        System.out.println(" [5] Mudar situação do Equipamento");
        System.out.println(" [6] Alterar responsável por equipamento");
        System.out.println(" [7] Lista de funcionários cadastrados");
        System.out.println(" [8] Pesquisar Equipamento");
        System.out.println(" [9] Editar Equipamento");
        ystem.out.println(" [10] Listar Equipamentos Antigos (> N anos)");
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

        } while (matriculaString.startsWith("101") == false
                || cadastroFuncionarios.buscarFuncionarioMatricula(matricula) != null);

        System.out.print("> Nome do Funcionario(a): ");
        String nome = in.nextLine();
        System.out.print("> Email do Funcionario(a): ");
        String email = in.nextLine();

        Funcionario novoFuncionario = new Funcionario(matricula, nome, email);
        cadastroFuncionarios.cadastrarFuncionarios(novoFuncionario);
        System.out.println("\n> Cadastrado com Sucesso!");
    }

    public void procurarFuncionarioPeloNome() {
        if (!cadastroFuncionarios.existemFuncionarios()) {
            System.out.println("> Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("Digite o nome: ");
        String nome = in.nextLine();
        List<Funcionario> encontrados = cadastroFuncionarios.buscarFuncionarioNome(nome);
        // Verifica se o funcionário foi encontrado
        if (!encontrados.isEmpty()) {
            System.out.println("Funcionário(s) encontrado(s): ");
            for (Funcionario encontrado : encontrados) {
                System.out.println("Matrícula: " + encontrado.getMatricula());
                System.out.println("Nome: " + encontrado.getNome());
                System.out.println("Email: " + encontrado.getEmail());
                System.out.println();
            }
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void alterarFuncionairios() {
        System.out.println("Digite o nome: ");
        String nome = in.nextLine();
        List<Funcionario> encontrados = cadastroFuncionarios.buscarFuncionarioNome(nome);
        // Verifica se o funcionário foi encontrado
        if (!encontrados.isEmpty()) {
            System.out.println("Funcionário(s) encontrado(s): ");
            for (Funcionario encontrado : encontrados) {
                System.out.println("Matrícula: " + encontrado.getMatricula());
                System.out.println("Nome: " + encontrado.getNome());
                System.out.println("Email: " + encontrado.getEmail());
                System.out.println();
            }
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void cadastroEquipamento() {
        System.out.println("\f CADASTRO EQUIPAMENTO");

        if (!cadastroFuncionarios.existemFuncionarios()) {
            System.out.println("> Nenhum funcionario cadastrado. Cadastro de equipamento impossivel.");
            return;
        }

        Equipamento aux;
        do {
            System.out.print("> Digite o ID ÚNICO do equipamento: ");
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
                        Equipamento novoEquipamento = new Equipamento(idEquipamento, nomeEquipamento,
                                descricaoEquipamento, dataAquisição, custoAquisicao, enumTipo, null);
                        cadastroEquipamentos.adicionaEquipamentos(novoEquipamento);

                    } else if (tipoEquipamento == 2) {

                        TipoEquipamento enumTipo = TipoEquipamento.FIXO;
                        Equipamento novoEquipmaneto = new Equipamento(idEquipamento, nomeEquipamento,
                                descricaoEquipamento, dataAquisição, custoAquisicao, enumTipo, null);
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

            System.out.print("> Nome do Equipamento: ");
            String nomeEquipamento = in.nextLine();

            System.out.print("> Descrição do Equipamento: ");
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
            } while (tipoEquipamento < 1 || tipoEquipamento > 2);

            TipoEquipamento enumTipo = (tipoEquipamento == 1) ? TipoEquipamento.MOVEL : TipoEquipamento.FIXO;
            Equipamento novoEquipamento = new Equipamento(idEquipamento, nomeEquipamento,
                    descricaoEquipamento, dataAquisição, custoAquisicao, enumTipo, null);
            cadastroEquipamentos.adicionaEquipamentos(novoEquipamento);

            cadastraFuncionarioResponsavel(idEquipamento);
            System.out.println("> Cadastrado com sucesso!");

        } while (false); // O loop principal foi ajustado para não repetir
    }

    public void pesquisaEquipamento() {
        System.out.println("\f PESQUISA DE EQUIPAMENTO");

        String opcao;
        do {
            System.out.println("\n> Escolha uma opção de pesquisa:");
            System.out.println("[1] ID");
            System.out.println("[2] Nome");
            System.out.println("[3] Descrição");
            System.out.println("[4] Tipo");
            System.out.println("[0] Voltar ao menu principal");
            System.out.print("> ");
            opcao = in.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("> Digite o ID do equipamento: ");
                    int id = in.nextInt();
                    cadastroEquipamentos.buscarEquipamentoId(id);
                    break;
                case "2":
                    System.out.print("> Digite o nome do equipamento: ");
                    String nome = in.nextLine();
                    cadastroEquipamentos.pesquisarEquipamentoNome(nome);
                    break;
                case "3":
                    System.out.print("> Digite a descrição do equipamento: ");
                    String descricao = in.nextLine();
                    cadastroEquipamentos.pesquisaEquipamentoDescricao(descricao);
                    break;
                case "4":
                    System.out.print("> Digite o tipo do equipamento (Móvel ou Fixo): ");
                    String tipo = in.nextLine();
                    if (tipo.equalsIgnoreCase("Móvel")) {
                        cadastroEquipamentos.pesquisaEquipamentoTipo(TipoEquipamento.MOVEL);
                    } else if (tipo.equalsIgnoreCase("Fixo")) {
                        cadastroEquipamentos.pesquisaEquipamentoTipo(TipoEquipamento.FIXO);
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }

    public void editarFuncionario() {
        if (!cadastroFuncionarios.existemFuncionarios()) {
            System.out.println("> Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\f EDITAR FUNCIONARIO");
        System.out.print("> Digite a matricula do funcionario: ");
        int matricula = in.nextInt();
        Funcionario f = cadastroFuncionarios.buscarFuncionarioMatricula(matricula);

        if (f != null) {
            System.out.println("[1] Editar nome");
            System.out.println("[2] Editar email");
            System.out.println("[3] Cancelar");
            System.out.print("> ");
            int op = in.nextInt();
            in.nextLine();
            switch (op) {
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
        } else {
            System.out.println("Nenhum funcionario encontrado com a matricula informada.");
        }
    }

    public void imprimeFuncionario(Funcionario f) {
        System.out.println("\f DADOS DO FUNCIONARIO");
        System.out.println(" - Matricula: " + f.getMatricula());
        System.out.println(" - Nome: " + f.getNome());
        System.out.println(" - Email: " + f.getEmail());
    }

    public void alterarSituacaoEquipamento() {
        System.out.println("\f ALTERAR SITUAÇÃO DO EQUIPAMENTO");

        if (!cadastroEquipamentos.existemEquipamentos()) {
            System.out.println("> Nenhum equipamento cadastrado!");
            return;
        }

        System.out.print("> Digite o ID do equipamento: ");
        int idEquipamento = in.nextInt();
        in.nextLine();

        Equipamento equipamento = cadastroEquipamentos.buscarEquipamentoId(idEquipamento);
        if (equipamento != null) {
            boolean equipamentoDisponivel = equipamento.equipamentoEstaDisponivel();
            System.out.println("A situação atual do equipamento é: "
                    + (equipamentoDisponivel ? "Disponível" : "Indisponível"));

            if (equipamentoDisponivel) {
                System.out.println("> O equipamento está disponível. Deseja indisponibilizá-lo? (S/N)");
                String resposta = in.nextLine();
                if (resposta.equalsIgnoreCase("S")) {
                    indisponibilizarEquipamento(idEquipamento);
                } else {
                    System.out.println("> Ação cancelada.");
                }
            } else {
                System.out.println("> O equipamento está indisponível. Deseja disponibilizá-lo? (S/N)");
                String resposta = in.nextLine();
                if (resposta.equalsIgnoreCase("S")) {
                    disponibilizarEquipamento(idEquipamento);
                } else {
                    System.out.println("> Ação cancelada.");
                }
            }

        } else {
            System.out.println("> Equipamento não encontrado.");
        }
    }

    public void listarFuncionarios() {
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");

        ArrayList<Funcionario> lista = cadastroFuncionarios.listaFuncionarios();

        if (lista.isEmpty()) {
            System.out.println("> Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : lista) {
                System.out.println("Matrícula: " + f.getMatricula());
                System.out.println("Nome: " + f.getNome());
                System.out.println("Email: " + f.getEmail());
                System.out.println("------------------------------");
            }
        }
    }

    public void alterarResponsavelEquipamento() {
        System.out.println("\n--- ALTERAR RESPONSÁVEL DE EQUIPAMENTO ---");

        int idEquipamento;
        Equipamento equipamento;

        while (true) {
            System.out.print("> Digite o ID do equipamento: ");
            idEquipamento = in.nextInt();
            in.nextLine();

            equipamento = cadastroEquipamentos.buscarEquipamentoId(idEquipamento);
            if (equipamento != null) {
                break;
            } else {
                System.out.println("> Equipamento não encontrado. Tente novamente.");
            }
        }

        System.out.println("> Equipamento: " + equipamento.getNome());
        System.out.println("> Responsável atual: " + equipamento.getFuncionario().getNome());

        int novaMatricula;
        Funcionario novoResponsavel;

        while (true) {
            System.out.print("> Digite a matrícula do novo responsável: ");
            novaMatricula = in.nextInt();
            in.nextLine();

            novoResponsavel = cadastroFuncionarios.buscarFuncionarioMatricula(novaMatricula);
            if (novoResponsavel != null) {
                break;
            } else {
                System.out.println("> Funcionário não encontrado. Tente novamente.");
            }
        }
        System.out.println("> Responsável alterado com sucesso!");
        System.out.println("> Novo responsável: " + novoResponsavel.getNome() + " (Matrícula: "
                + novoResponsavel.getMatricula() + ")");
    }

    public void indisponibilizarEquipamento(int idEquipamento) {
        System.out.println("\f INDISPONIBILIZAR EQUIPAMENTO");
        Equipamento equipamento = cadastroEquipamentos.buscarEquipamentoId(idEquipamento);
        if (equipamento != null) {
            if (equipamento.equipamentoEstaDisponivel()) {
                System.out.print("> Motivo da Indisponibilidade: ");
                String motivo = in.nextLine();
                equipamento.indisponibilizarEquipamento(motivo);
                System.out.println("> Equipamento indisponibilizado com sucesso!");
            } else {
                System.out.println("> Equipamento já está indisponível.");
            }
        } else {
            System.out.println("> Equipamento não encontrado.");
        }
    }

    public void disponibilizarEquipamento(int idEquipamento) {
        System.out.println("\f DISPONIBILIZAR EQUIPAMENTO");
        Equipamento equipamento = cadastroEquipamentos.buscarEquipamentoId(idEquipamento);
        if (equipamento != null) {
            if (!equipamento.equipamentoEstaDisponivel()) {
                equipamento.disponibilizarEquipamento();
                System.out.println("> Equipamento disponibilizado com sucesso!");
            } else {
                System.out.println("> Equipamento já está disponível.");
            }
        } else {
            System.out.println("> Equipamento não encontrado.");
        }
    }

    public void cadastraFuncionarioResponsavel(int idEquipamento) {
        Funcionario funcionario;
        int idFuncionario;
        int idEquipa = idEquipamento;

        do {
            System.out.println("\n> Digite o ID do funcionário responsável: ");
            idFuncionario = in.nextInt();
            funcionario = cadastroFuncionarios.buscarFuncionarioMatricula(idFuncionario);
            if (funcionario == null) {
                System.out.print("Não foi possível encontrar um funcionário com essa matrícula!");
            }
        } while (funcionario == null);

        Equipamento equipamento = cadastroEquipamentos.buscarEquipamentoId(idEquipa);

        if (equipamento != null) {
            equipamento.setFuncionario(funcionario);
            funcionario.addEquipamento(equipamento);
        }
    }

    public void editarEquipamento() {
        System.out.println("\f EDITAR EQUIPAMENTO");
        System.out.print("> Digite o ID do equipamento: ");
        int idEquipamento = in.nextInt();
        in.nextLine();

        Equipamento equipamento = cadastroEquipamentos.buscarEquipamentoId(idEquipamento);
        if (equipamento != null) {
            System.out.println("[1] Editar descrição com validação");
            System.out.println("[2] Editar descrição sem validação");
            System.out.println("[3] Cancelar");
            System.out.print("> ");
            int escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 1:
                    System.out.print("> Digite a nova descrição: ");
                    String novaDescVal = in.nextLine();
                    equipamento.edicaoEquipamento(novaDescVal);
                    System.out.println("> Equipamento atualizado com validação.");
                    break;
                case 2:
                    System.out.print("> Digite a nova descrição: ");
                    String novaDesc = in.nextLine();
                    equipamento.editarDescricao(novaDesc);
                    System.out.println("> Equipamento atualizado sem validação.");
                    break;
                case 3:
                    System.out.println("> Operação cancelada.");
                    return;
                default:
                    System.out.println("> Opção inválida, operação cancelada.");
                    return;
            }
            System.out.println("Nova descrição do equipamento: " + equipamento.getDescricao());
        } else {
            System.out.println("Nenhum equipamento encontrado com o ID informado.");
        }
    }

    public void listarEquipamentosAntigos() {
        System.out.print("> Informe a idade mínima dos equipamentos (em anos): ");
        int anos = in.nextInt();
        in.nextLine();
        cadastroEquipamentos.listarEquipamentosAntigos(anos);
    }

}
