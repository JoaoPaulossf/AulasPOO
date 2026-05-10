import java.util.Scanner;

public class Multa {
	private String infracao;
	private Float valor;
	private static int contadorMultas = 0;
	
	Scanner input = new Scanner(System.in);

	public Multa(String infracao, Float valor){
		this.infracao = infracao;
		this.valor = valor;
		contadorMultas++;
	}

	public static int quantidadeInstancias(){
		return contadorMultas;
	}

	public float getValor(){
		return valor;
	}

	public String getInfracao(){
		return infracao;
	}
}
