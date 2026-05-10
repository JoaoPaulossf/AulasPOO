import java.util.Scanner;
import java.util.Vector;

public class Proprietario {
	public String nome;
	public Vector<Carro> carros = new Vector<>();
	
	public String cnh;
	
	Scanner input = new Scanner(System.in);

	public void cadastrarCarro(Carro carro) {
		carros.add(carro);
	}
	
	public void criarCarro() {	
		Carro novoCarro = new Carro();
		System.out.println("Entre com o modelo do carro:");
		novoCarro.modelo = input.nextLine();
		System.out.println("Entre com a placa do carro:");
		novoCarro.placa = input.nextLine();
		cadastrarCarro(novoCarro);
	}
	
	
	public void listarCarros() {
		if(carros != null) {
			for (int i = 0; i < carros.size(); i++) {
				Carro carroAtual = carros.get(i);
				System.out.println(carroAtual.modelo + "\n" + carroAtual.placa);
			}
		}else {
			System.out.println("Sem carros cadastrados");
		}
	}
}
