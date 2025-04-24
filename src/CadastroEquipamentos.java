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

    public void pesquisarEquipamentoNome(String nome) {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento aux : equipamentos) {
            if (aux.getNome().equalsIgnoreCase(nome)) {
                resultado.add(aux);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Equipamentos encontrados:");
            for (Equipamento aux : resultado) {
                System.out.println(aux);
            }
        }
    }

    public void pesquisaEquipamentoDescricao(String descricao) {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento aux : equipamentos) {
            if (aux.getDescricao().equalsIgnoreCase(descricao)) {
                resultado.add(aux);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Equipamentos encontrados:");
            for (Equipamento aux : resultado) {
                System.out.println(aux);
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
            for (Equipamento aux : resultado) {
                System.out.println(aux);
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
            for (Equipamento aux : resultado) {
                System.out.println(aux);
            }
        }
    }

    public void pesquisaEquipamentoData(String data) {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento aux : equipamentos) {
            if (aux.getDataAquisicao().equalsIgnoreCase(data)) {
                resultado.add(aux);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("Equipamento não encontrado.");
        } else {
            System.out.println("Equipamentos encontrados:");
            for (Equipamento aux : resultado) {
                System.out.println(aux);
            }
        }
    }
}
