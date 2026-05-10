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
		String placaNova = new String();
		
		System.out.println("Entre com o modelo do carro:");
		novoCarro.modelo = input.nextLine();
		
		while(placaNova.length() != 7){
			System.out.println("Entre com a placa do carro:");
			placaNova = input.nextLine();
			if(placaNova.length() != 7){
				System.out.println("A placa deve ter 7 caracteres!\n");
			}
		}
		novoCarro.placa = placaNova;
		cadastrarCarro(novoCarro);
	}
	
	public boolean temCarro(){
		return carros != null && !carros.isEmpty();
	}
	
	public void listarCarros() {
		if(temCarro()) {
			for (int i = 0; i < carros.size(); i++) {
				Carro carroAtual = carros.get(i);
				System.out.println("-- "+(i+1) + "º Carro --");
				System.out.println("Modelo:" + carroAtual.modelo + "\n" + "Placa:" + carroAtual.placa);
			}
		}else {
			System.out.println("Sem carros cadastrados");
		}
	}

}
