public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String endereco;

    public Pessoa(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
}