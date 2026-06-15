public class ContaCorrente extends ContaBancaria{
    protected double taxaOperacao;
    public ContaCorrente(String agencia, int numeroConta, double saldo, double taxaOperacao) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.taxaOperacao = taxaOperacao;
    }

    @Override
    double sacar(double valor) {
        valor += taxaOperacao;
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque.");
            salvarTransacao("Tentativa de saque: R$ " + valor + " - Saldo insuficiente");
            return saldo;
        }
        saldo -= valor;
        salvarTransacao("Saque: R$ " + valor);
        return saldo;
    }

    @Override
    double depositar(double valor) {
        if(saldo + valor < taxaOperacao){
            System.out.println("Valor do depósito é insuficiente para cobrir a taxa de operação.");
            salvarTransacao("Tentativa de depósito: R$ " + valor + " - Valor insuficiente para cobrir a taxa de operação");
            return saldo;
        }
        saldo += (valor - taxaOperacao);
        salvarTransacao("Depósito: R$ " + valor);
        return saldo;
    }

    @Override
    void exibirExtrato(int numConta) {
        if (numConta == this.numeroConta) {
            System.out.println("Extrato da Conta Corrente:");
            System.out.println("Agência: " + agencia);
            System.out.println("Número da Conta: " + numeroConta);
            System.out.println("Saldo: R$ " + saldo);
            System.out.println("Extrato:");
            for (String transacao : extrato) {
                System.out.println(transacao);
            }
        } else {
            System.out.println("Número de conta inválido.");
        }
    }
}