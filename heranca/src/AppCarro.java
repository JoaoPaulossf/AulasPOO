import java.util.Scanner;

public class AppCarro {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String marca = input.nextLine();
        String modelo = input.nextLine();
        int ano = input.nextInt();
        Carro carro = new Carro(modelo, marca, ano);
        System.out.println("Ano:" + carro.getAno() + "\nModelo:" + carro.getModelo() + "\nMarca:" + carro.getMarca());
        input.close();
    }
}
