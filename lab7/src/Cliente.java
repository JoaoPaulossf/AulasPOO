import java.time.LocalDate;

public class Cliente extends Pessoa {
    protected LocalDate dataAbertura;
    protected ContaBancaria conta;

    public Cliente(String nome, String cpf, String endereco, ContaBancaria conta, LocalDate dataAbertura) {
        super(nome, cpf, endereco);
        this.conta = conta;
        this.dataAbertura = dataAbertura;
    }
}