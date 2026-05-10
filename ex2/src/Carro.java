import java.util.Vector;
import java.util.Scanner;

public class Carro {
	public String modelo;
	public String placa;
	
	private Vector<Multa> multas = new Vector<>();
	Scanner input = new Scanner(System.in);
	
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

	public boolean verificarMultas(){
		return multas != null && !multas.isEmpty();
	}

	public void exibirMultas(){
		if(verificarMultas()){
			float somaMultas = 0;
			for (int i = 0; i < multas.size(); i++) {
				Multa multaAtual = multas.get(i);
				System.out.println("-- "+(i+1) + "º multa --");
				System.out.println("\nInfração:" + multaAtual.infracao + "\n" + String.format("Valor:R$ %.2f\n", multaAtual.valor));
				somaMultas += multaAtual.valor;
			}
			System.out.printf("Valor total a pagar para o detran: R$%.2f\n",somaMultas);
		}else{
			System.out.printf("\nParabéns! O seu veiculo %s não tem infrações!\n", this.modelo);
		}
	}
		
}
