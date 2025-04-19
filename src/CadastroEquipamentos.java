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
}
