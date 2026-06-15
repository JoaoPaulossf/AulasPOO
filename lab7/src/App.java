import java.util.Vector;
public class App {
    public static Vector<Cliente> clientes = new Vector<Cliente>();
    public static void main(String[] args) throws Exception {
        System.out.println("Bem-vindo ao sistema bancário!");
        int opcao = 0;
        Cliente c = null;
        while (opcao != 5) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Operações Bancárias");
            System.out.println("3. Buscar Cliente pelo número da conta");
            System.out.println("4. Exibir Extrato da Conta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(System.console().readLine());

            switch (opcao) {
                case 1:
                    int numeroConta, tipoConta;
                    String nome, cpf, endereco;
                    double dinheiroInicial;

                    System.out.print("Digite o nome do cliente: ");
                    nome = System.console().readLine();
                    System.out.print("Digite o CPF do cliente: ");
                    cpf = System.console().readLine();
                    System.out.print("Digite o endereço do cliente: ");
                    endereco = System.console().readLine();
                    System.out.print("Digite o número da conta do cliente: ");
                    numeroConta = Integer.parseInt(System.console().readLine());
                    if(clientes.stream().anyMatch(clienteBusca -> clienteBusca.conta.numeroConta == numeroConta)) {
                        System.out.println("Número de conta já existe. Cliente não cadastrado.");
                        break;
                    }
                    System.out.print("Digite o tipo da conta (1 - Corrente, 2 - Poupança): ");
                    tipoConta = Integer.parseInt(System.console().readLine());
                    System.out.print("Digite o saldo inicial da conta: ");
                    dinheiroInicial = Double.parseDouble(System.console().readLine());
                    ContaBancaria conta;
                    if(tipoConta == 1){
                        conta = new ContaCorrente("0001", numeroConta, dinheiroInicial, 5.0);
                    } else if(tipoConta == 2){
                        conta = new ContaEspecial("0001", numeroConta, dinheiroInicial);
                    } else {
                        System.out.println("Tipo de conta inválido");
                        break;
                    }
                    Cliente cliente = new Cliente(nome, cpf, endereco, conta, java.time.LocalDate.now());
                    clientes.add(cliente);
                    break;
                case 2:
                    int numConta, tipoOperacao;
                    double valor;
                    System.out.print("Digite o número da conta: ");
                    numConta = Integer.parseInt(System.console().readLine());
                    for(Cliente clienteBusca : clientes){
                        if(clienteBusca.conta.numeroConta == numConta){
                            c = clienteBusca;
                            break;
                        }
                    }
                    if(c == null){
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    System.out.print("Digite o tipo de operação (1 - Depósito, 2 - Saque): ");
                    tipoOperacao = Integer.parseInt(System.console().readLine());
                    System.out.print("Digite o valor da operação: ");
                    valor = Double.parseDouble(System.console().readLine());
                    if(tipoOperacao == 1){
                        c.conta.depositar(valor);
                        break;
                    } else if(tipoOperacao == 2){
                        c.conta.sacar(valor);
                        break;
                    } else {
                        System.out.println("Tipo de operação inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da conta para busca: ");
                    numConta = Integer.parseInt(System.console().readLine());
                    boolean encontrado = false;
                    for (Cliente buscaClientes : clientes) {
                        if (buscaClientes.conta.numeroConta == numConta) {
                            c = buscaClientes;
                            encontrado = true;
                        }
                    }
                    if(c == null){
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    System.out.println("Cliente encontrado:");
                    System.out.println("Nome: " + c.nome);
                    System.out.println("CPF: " + c.cpf);
                    System.out.println("Endereço: " + c.endereco);
                    System.out.println("Número da Conta: " + c.conta.numeroConta);
                    System.out.println("Data de Abertura: " + c.dataAbertura);
                    break;
                case 4:
                    System.out.print("Digite o número da conta para exibir o extrato: ");
                    numConta = Integer.parseInt(System.console().readLine());
                    encontrado = false;
                    for (Cliente clienteBusca : clientes) {
                        if (clienteBusca.conta.numeroConta == numConta) {
                            c = clienteBusca;
                            encontrado = true;
                            c.conta.exibirExtrato(numConta);
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema. Obrigado por usar!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
