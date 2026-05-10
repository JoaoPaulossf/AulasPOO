import java.util.Scanner;

public class AppDetran {
	private Scanner input;

	public Proprietario cadastrarProprietario() {
		Proprietario dono = new Proprietario();
		input = new Scanner(System.in);
		System.out.println("Nome do proprietário:");
		dono.nome = input.nextLine();
		System.out.println("CNH:");
		dono.cnh = input.nextLine();
		return dono;
	}	
	public void teste1() {
		Proprietario dono = cadastrarProprietario();
		dono.criarCarro();
		dono.carros.get(0).cadastrarMulta();
		dono.listarCarros();
	}

	public void teste2(){
		int opcao = -1;
		Proprietario dono = null;
		while(opcao != 0){
			System.out.println("\n--Opções--\n1 para cadastrar proprietário\n2 para cadastrar carro\n3 para cadastrar multa\n4 para mostrar as multas de um carro \n5 para exibir todos os carros do proprietário\n0 para sair do programa");
			input = new Scanner(System.in);
			opcao = input.nextInt();
			switch (opcao) {
				case 1:
					dono = cadastrarProprietario();
					break;
				case 2:
					if(dono != null){
						dono.criarCarro();
					}else{
						System.out.println("\nVocê ainda não cadastrou um proprietário!!!");
					}
					break;
				case 3:
					if(dono != null && dono.temCarro()){
						dono.listarCarros();
						System.out.println("Digite o indice do carro que a multa será aplicada:");
						int indice = input.nextInt();
						dono.carros.get(indice - 1).cadastrarMulta();
					}else{
						System.out.println("\nVocê ainda não cadastrou nenhum carro ou proprietário!\n");
					}
					break;
				case 4:
					if (dono != null && dono.temCarro()) {
						dono.listarCarros();
						System.out.println("Digite o indice do carro que deseja checar a situação:");
						int indice = input.nextInt();
						dono.carros.get(indice - 1).exibirMultas();
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
		
		app.teste1();

		app.teste2();
	}
}
