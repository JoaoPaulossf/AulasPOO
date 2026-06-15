public class Golpe {
    private String nomeGolpe;
    private int poderOfensivo;

    public Golpe (String nomeGolpe,int poderOfensivo){
        this.nomeGolpe = nomeGolpe;
        this.poderOfensivo = poderOfensivo;
    }

    public String getNomeGolpe() {
        return nomeGolpe;
    }

    public int getPoderOfensivo() {
        return poderOfensivo;
    }

    public void exibirGolpe(){
        System.out.println("Golpe:" + getNomeGolpe() + "\nPoder ofensivo:" + getPoderOfensivo());
    }
}
