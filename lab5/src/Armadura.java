

public class Armadura {
    private  double poderDefesa;
    private String tipoArmadura;

    public Armadura(double poderDefesa,String tipoArmadura){
        this.poderDefesa = poderDefesa;
        this.tipoArmadura = tipoArmadura;
    }
    
    public double getPoderDefesa(){
        return poderDefesa;
    }

    public void exibirArmadura(){
        System.out.println("Tipo da armadura: " + tipoArmadura + "\nPoder de defesa: " + poderDefesa);
    }
}
