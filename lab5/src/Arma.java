import java.util.ArrayList;
import java.util.Random;
public class Arma {
    private String nomeArma;
    private ArrayList<Golpe> golpes = new ArrayList<>();

    public Arma(String nome){
        nomeArma = nome;
    }

    public String getNomeArma() {
        return nomeArma;
    }

    public ArrayList<Golpe> getGolpes() {
        return golpes;
    }

    public int atacar (){
        int quantidadeGolpes = golpes.size();
        Random random = new Random();
        Golpe golpeSorteado = golpes.get(random.nextInt(quantidadeGolpes));
        return golpeSorteado.getPoderOfensivo();
    }

    public void adicionarGolpe(Golpe golpe){
        golpes.add(golpe);
    }

    public void exibirArma(){
        System.out.println("Arma:" + getNomeArma());
        for(int i = 0; i < golpes.size() ; i++){
            golpes.get(i).exibirGolpe();
        }
    }
}
