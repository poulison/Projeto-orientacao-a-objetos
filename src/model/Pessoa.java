package model;

/**
 *
 * @author Paulo
 */
public class Pessoa {
    private String nome, CPF, senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa() {
    }

    public Pessoa(String nome, String CPF, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
    }
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", CPF=" + CPF + ", senha=" + senha + '}';
    }
    
}
