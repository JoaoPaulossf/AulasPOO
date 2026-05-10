import java.util.Vector;
import java.util.Scanner;

public class Carro {
	public String modelo;
	public String placa;
	Scanner input = new Scanner(System.in);
	
	private Vector<Multa> multas = new Vector<>();
	
	public void adicionarMulta(Multa multa) {
		multas.add(multa);
	}
	
	public void cadastrarMulta() {
		Multa novaMulta = new Multa();
		System.out.println("Entre com o tipo de infração:");
		novaMulta.infracao = input.nextLine();
		System.out.println("Entre com o valor da Multa:");
		novaMulta.valor = input.nextFloat();
		adicionarMulta(novaMulta);
	}
		
}
