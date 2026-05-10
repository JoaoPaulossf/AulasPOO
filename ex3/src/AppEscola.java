import java.util.Scanner;

public class AppEscola {

	public static void main(String[] args) {
		Caderno cadernoAluno = new Caderno();
		cadernoAluno.marca = "Redragon";
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		float media = 0,input;
		int i = 0;
		
		Aluno novoAluno = new Aluno();
		
		while(i < 3){
			input = in.nextFloat();
			if(input < 0 || input > 10) {
				System.out.println("Nota invalida, tentar novamente!");
			}else {
				novoAluno.notas[i] = input;
				media += novoAluno.notas[i];
				i++;
			}
		}
		media = media / 3;
		if(media >= 7) {
			novoAluno.status = "Aprovado";
		}else {
			novoAluno.status = "Reprovado";
		}
		novoAluno.nome = "Carlos";
		novoAluno.anoNascimento = 2005;
		novoAluno.matricula = 2013203456;
		novoAluno.meuCaderno = cadernoAluno;
		
		System.out.println("Nome:" + novoAluno.nome + "\nAno de nascimento:" + novoAluno.anoNascimento + "\nMatricula:" + novoAluno.matricula + "\nResultado Final:" + novoAluno.status + "\nMarca do caderno:" + novoAluno.meuCaderno.marca);
	}

}
