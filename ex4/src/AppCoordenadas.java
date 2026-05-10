import java.util.Scanner;

public class AppCoordenadas {

	public static void main(String[] args) {
		Ponto ponto1 = new Ponto();
		Ponto ponto2 = new Ponto();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		ponto1.x = in.nextFloat();
		ponto1.y = in.nextFloat();
		
		if(ponto1.x >= 0) {
			if(ponto1.y >= 0) {
				ponto1.quadrante = "1º quadrante";
			}else {
				ponto1.quadrante = "4º quadrante";
			}
		}else {
			if(ponto1.y >= 0) {
				ponto1.quadrante = "2º quadrante";
			}else {
				ponto1.quadrante = "3º quadrante";
			}
		}
		System.out.println(ponto1.quadrante);
		System.out.println("Preencha as coordenadas do segundo ponto");
		ponto2.x = in.nextFloat();
		ponto2.y = in.nextFloat();
		
	}

}
