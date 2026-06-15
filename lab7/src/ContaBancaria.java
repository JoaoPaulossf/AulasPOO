import java.util.Vector;

public abstract class ContaBancaria{
    protected String agencia;
    protected int numeroConta;
    protected double saldo;
    protected Vector<String> extrato = new Vector<String>();

    public void salvarTransacao(String transacao){
        extrato.add(transacao);
    }
    abstract double sacar(double valor);
    abstract double depositar(double valor);
    abstract void exibirExtrato(int numConta);
}