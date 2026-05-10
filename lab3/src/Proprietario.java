import java.util.Scanner;
import java.util.Vector;

//precisa de construtor
public class Proprietario {
	private String nome;
	private String cnh;
	
	private Vector<Carro> carros = new Vector<>();
	
	private static int contadorProprietarios = 0;

	Scanner input = new Scanner(System.in);
	
	public Proprietario (String  nome, String cnh){
		this.nome = nome;
		this.cnh = cnh;
		contadorProprietarios++;
	}


	public String getNome (){
		return nome;
	}

	public String getCNH(){
		return cnh;
	}

	public Vector<Carro> getCarros(){
		return carros;
	}

	public void setNome (String novoNome){
		nome = novoNome;
	}

	public void setCNH (String novaCnh) { 
		cnh = novaCnh;
	}

	public static int quantidadeInstancias(){
		return contadorProprietarios;
	}

	public void cadastrarNovoCarro() {
		String modelo;
		System.out.println("Digite o modelo do carro:");
		modelo = input.nextLine();

		Carro novoCarro = new Carro(modelo);	
		carros.add(novoCarro);
	}
	
	public boolean temCarro(){
		return carros != null && !carros.isEmpty();
	}
	
	public void listarCarros() {
		if(temCarro()) {
			for (int i = 0; i < carros.size(); i++) {
				Carro carroAtual = carros.get(i);
				System.out.println("-- "+(i+1) + "º Carro --");
				System.out.println("Modelo:" + carroAtual.getModelo() + "\n" + "Placa:" + carroAtual.getPlaca());
			}
		}else {
			System.out.println("Sem carros cadastrados");
		}
	}

}
