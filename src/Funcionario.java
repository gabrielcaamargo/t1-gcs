public class Funcionario {

    private int matricula;
    private String nome;
    private String email;

    public Funcionario(int matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    public void editarNomes(String novoNome) {
        this.nome = novoNome;
    }

    public void editarEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
