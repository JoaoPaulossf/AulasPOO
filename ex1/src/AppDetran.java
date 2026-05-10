import java.util.Scanner;

public class AppDetran {
	Scanner input = new Scanner(System.in);
	public Proprietario cadastrarProprietario() {
		Proprietario dono = new Proprietario();
		dono.nome = input.nextLine();
		dono.cnh = input.nextLine();
		return dono;
	}	
	public void teste1() {
		Proprietario dono = cadastrarProprietario();
		dono.criarCarro();
		dono.carros.get(0).cadastrarMulta();
		dono.listarCarros();
		
	}
	public static void main(String args[]) {
		AppDetran app = new AppDetran();
		app.teste1();
	}
}
