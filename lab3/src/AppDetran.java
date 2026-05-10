import java.util.Scanner;

public class AppDetran {
	private Scanner input = new Scanner(System.in);

	public void teste1() {
		String nome,cnh,infracao;
		float valorMulta;

		System.out.println("Digite o nome  do motorista:");
		nome = input.nextLine();
		System.out.println("Digite o CNH:");
		cnh = input.nextLine();
		
		Proprietario dono = new Proprietario(nome, cnh);
		dono.cadastrarNovoCarro();
		
		System.out.println("Digite o tipo de infração:");
		infracao = input.nextLine();
		System.out.println("Digite o valor da multa:");
		valorMulta = input.nextFloat();

		Multa multa = new Multa(infracao, valorMulta);
		dono.getCarros().get(0).adicionarMulta(multa);
		dono.listarCarros();
		dono.getCarros().get(0).exibirMultas();
		System.out.println("Proprietários:" + Proprietario.quantidadeInstancias() + "\nCarros:" + Carro.quantidadeInstancias() + "\nMultas:" + Multa.quantidadeInstancias());
	}

	public void teste2(){
		int opcao = -1;
		Proprietario dono = null;
		while(opcao != 0){
			System.out.println("\n--Opções--\n1 para cadastrar proprietário\n2 para cadastrar carro\n3 para cadastrar multa\n4 para mostrar as multas de um carro \n5 para exibir todos os carros do proprietário\n0 para sair do programa");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					String nome,cnh;
					
					System.out.println("Digite o nome  do motorista:");
					nome = input.nextLine();
					System.out.println("Digite o CNH:");
					cnh = input.nextLine();
		
					dono = new Proprietario(nome,cnh);
					break;
				case 2:
					if(dono != null){
						dono.cadastrarNovoCarro();
					}else{
						System.out.println("\nVocê ainda não cadastrou um proprietário!!!");
					}
					break;
				case 3:
					if(dono != null && dono.temCarro()){
						String infracao;
						float valorMulta;
						
						dono.listarCarros();
						System.out.println("Digite o indice do carro que a multa será aplicada:");
						int indice = input.nextInt();
						input.nextLine();
						
						System.out.println("Digite o tipo de infração:");
						infracao = input.nextLine();
						System.out.println("Digite o valor da multa:");
						valorMulta = input.nextFloat();

						Multa multa = new Multa(infracao, valorMulta);
						dono.getCarros().get(indice - 1).adicionarMulta(multa);
					}else{
						System.out.println("\nVocê ainda não cadastrou nenhum carro ou proprietário!\n");
					}
					break;
				case 4:
					if (dono != null && dono.temCarro()) {
						dono.listarCarros();
						System.out.println("Digite o indice do carro que deseja checar a situação:");
						int indice = input.nextInt();
						input.nextLine();
						dono.getCarros().get(indice - 1).exibirMultas();
					}else{
						System.out.println("\nVocê ainda não cadastrou nenhum carro ou proprietário!\n");
					}
					break;
				case 5:
					if(dono != null && dono.temCarro()){
						dono.listarCarros();
					}else{
						System.out.println("\nVocê ainda não cadastrou nenhum carro ou proprietário!\n");
					}
					break;
				case 0:
					System.out.println("Saindo do programa...\n");
					break;
				default:
					System.out.println("Opção inválida!!!\n");
					break;
			}
		}
	}
	public static void main(String args[]) {
		AppDetran app = new AppDetran();
		
		//app.teste1();

		app.teste2();
	}
}
