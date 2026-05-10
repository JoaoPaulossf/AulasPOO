public class Carro extends Veiculo{
    private String modelo;

    public Carro(String modelo,String marca, int ano){
        super(marca, ano);
        this.modelo = modelo;
    }

    public String getModelo(){
        return modelo;
    }
}
