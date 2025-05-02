import java.util.*;

public class CadastroEquipamentos {
    ArrayList<Equipamento> equipamentos;

    public CadastroEquipamentos() {
        equipamentos = new ArrayList<>();
    }

    public void adicionaEquipamentos(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public Equipamento buscarEquipamentoId(int id) {
        for (Equipamento aux : equipamentos) {
            if (aux.getId() == id) {
                return aux;
            }
        }
        return null;
    }

    public boolean existemEquipamentos() {
        return !equipamentos.isEmpty();
    }

    public void pesquisarEquipamentoNome(String nome) {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento aux : equipamentos) {
            if (aux.getNome().contains(nome)) {
                resultado.add(aux);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Equipamentos encontrados:");
            int count = 1;
            for (Equipamento aux : resultado) {
                System.out.println("Equipamento " + count++ + ":");
                count++;
                System.out.println("| Nome: " + aux.getNome() + " |");
                System.out.println("| Descrição: " + aux.getDescricao() + " |");
                System.out.println("| Tipo: " + aux.getTipoEquipamento() + " |");
            }
        }
    }

    public void pesquisaEquipamentoDescricao(String descricao) {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento aux : equipamentos) {
            if (aux.getDescricao().contains(descricao)) {
                resultado.add(aux);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Equipamentos encontrados:");
            int count = 1;
            for (Equipamento aux : resultado) {
                System.out.println("Equipamento " + count++ + ":");
                count++;
                System.out.println("| Nome: " + aux.getNome() + " |");
                System.out.println("| Descrição: " + aux.getDescricao() + " |");
                System.out.println("| Tipo: " + aux.getTipoEquipamento() + " |");
            }
        }
    }

    public void pesquisaEquipamentoTipo(TipoEquipamento tipo) {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento aux : equipamentos) {
            if (aux.getTipoEquipamento() == tipo) {
                resultado.add(aux);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Equipamentos encontrados:");
            int count = 1;
            for (Equipamento aux : resultado) {
                System.out.println("Equipamento " + count++ + ":");
                count++;
                System.out.println("| Nome: " + aux.getNome() + " |");
                System.out.println("| Descrição: " + aux.getDescricao() + " |");
                System.out.println("| Tipo: " + aux.getTipoEquipamento() + " |");
            }
        }
    }

    public void pesquisaEquipamentoValor(double valor) {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento aux : equipamentos) {
            if (aux.getValorAquisicao() == valor) {
                resultado.add(aux);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Equipamentos encontrados:");
            int count = 1;
            for (Equipamento aux : resultado) {
                System.out.println("Equipamento " + count++ + ":");
                count++;
                System.out.println("| Nome: " + aux.getNome() + " |");
                System.out.println("| Descrição: " + aux.getDescricao() + " |");
                System.out.println("| Tipo: " + aux.getTipoEquipamento() + " |");
            }
        }
    }

    public void pesquisaEquipamentoData(String data) {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento aux : equipamentos) {
            if (aux.getDataAquisicao().contains(data)) {
                resultado.add(aux);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Equipamentos encontrados:");
            int count = 1;
            for (Equipamento aux : resultado) {
                System.out.println("Equipamento " + count++ + ":");
                count++;
                System.out.println("| Nome: " + aux.getNome() + " |");
                System.out.println("| Descrição: " + aux.getDescricao() + " |");
                System.out.println("| Tipo: " + aux.getTipoEquipamento() + " |");
            }
        }
    }

    public void listarEquipamentosAntigos(int anosLimite) {
        boolean encontrou = false;

        for (Equipamento eq : equipamentos) {
            String data = eq.getDataAquisicao(); // formato: dd/MM/yyyy
            String[] partes = data.split("/");

            if (partes.length == 3) {
                int anoAquisicao = Integer.parseInt(partes[2]);
                int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

                int anosDeUso = anoAtual - anoAquisicao;

                if (anosDeUso > anosLimite) {
                    System.out.println("ID: " + eq.getId() +
                            " | Nome: " + eq.getNome() +
                            " | Data de Aquisição: " + eq.getDataAquisicao() +
                            " | Anos de uso: " + anosDeUso);
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            System.out.println("> Nenhum equipamento com mais de " + anosLimite + " anos de uso.");
        } else {
            System.out.println("\n> ATENÇÃO: Equipamentos antigos podem precisar ser substituídos ou aposentados.");
        }
    }

}
