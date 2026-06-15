public class ContaEspecial extends ContaBancaria{
    protected double limite;

    public ContaEspecial( String agencia, int numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limite = saldo*2;
    }

    @Override
    public double sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            salvarTransacao("Saque: R$ " + valor);
            return valor;
        }else {
            System.out.println("Saldo insuficiente, incluindo o limite.");
            salvarTransacao("Tentativa de saque: R$ " + valor + " - Saldo insuficiente");
            return 0;
        }
    }

    public double depositar(double valor) {
        saldo += valor;
        salvarTransacao("Depósito: R$ " + valor);
        return saldo;
    }

    public void exibirExtrato(int numConta) {
        if (numConta == this.numeroConta) {
            System.out.println("Extrato da Conta Especial:");
            System.out.println("Agência: " + agencia);
            System.out.println("Número da Conta: " + numeroConta);
            System.out.println("Saldo: R$ " + saldo);
            System.out.println("Limite: R$ " + limite);
            System.out.println("Extrato:");
            for (String transacao : extrato) {
                System.out.println(transacao);
            }
        } else {
            System.out.println("Número de conta inválido.");
        }
    }
}