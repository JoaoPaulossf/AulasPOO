import java.util.Vector;
import java.util.Random;
import java.util.Scanner;

public class Carro {
	private String modelo;
	private String placa;
	private static int contadorCarros = 0;
	
	private Vector<Multa> multas = new Vector<>();
	Scanner input = new Scanner(System.in);

	public Carro(String modelo){
		this.modelo = modelo;
		placa = gerarPlaca();
		contadorCarros++;
	}

	public String getModelo(){
		return modelo;
	}

	public String getPlaca(){
		return placa;
	}

	public Vector<Multa> getMultas(){
		return multas;
	}
	
	public void adicionarMulta(Multa multa) {
		multas.add(multa);
	}

	public static int quantidadeInstancias(){
		return contadorCarros;
	}

	private String gerarPlaca(){
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digitos = "0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int tamanho = 4;

		for (int i = 0; i < tamanho; i++){
			if(i == 3){
				int index = random.nextInt(digitos.length());
				sb.append("-");
				sb.append(digitos.charAt(index));
			}
			int index = random.nextInt(alfabeto.length());
			sb.append(alfabeto.charAt(index));
		}
		sb.append(Sequencial.getSequencia());

		return sb.toString();
	}

	private boolean verificarMultas(){
		return multas != null && !multas.isEmpty();
	}

	public void exibirMultas(){
		if(verificarMultas()){
			float somaMultas = 0;
			for (int i = 0; i < multas.size(); i++) {
				Multa multaAtual = multas.get(i);
				System.out.println("-- "+(i+1) + "º multa --");
				System.out.println("\nInfração:" + multaAtual.getInfracao() + "\n" + String.format("Valor:R$ %.2f\n", multaAtual.getValor()));
				somaMultas += multaAtual.getValor();
			}
			System.out.printf("Valor total a pagar para o detran: R$%.2f\n", somaMultas);
		}else{
			System.out.printf("\nParabéns! O seu veiculo %s não tem infrações!\n", modelo);
		}
	}
		
}
