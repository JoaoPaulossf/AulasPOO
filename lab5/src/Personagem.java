public class Personagem {
    private double valorVida;
    private String nome;
    private static int contador = 1;

    public Personagem(String nome){
        this.nome = nome;
        valorVida = 100;
        contador++;
    }
    public Personagem(){
        nome = "Misterioso nº" + contador;
        valorVida = 100;
        contador++;
    }

    public String getNome (){
        return nome;
    }
    
    public double getValorVida (){
        return valorVida;
    }


    public void setValorVida(double valorVida){
        this.valorVida = valorVida;
    }

    public void exibirPersonagem(){
        System.out.println(toString());
    }
    
    public boolean estaVivo(){
        if (valorVida > 0) return true;
        return false;
    }

    public void atacar(Personagem adversario){
        int poderOfensivo = (int)(Math.random() * 10);
        adversario.atualizarVida(poderOfensivo);
    }

    public void atualizarVida(int poderOfensivo){
        valorVida -= poderOfensivo;
    }

    public boolean ehGladiador(){
        if(this instanceof Gladiador){
            return true;
        }
        return false;
    }

    public String toString(){
        return "nome do personagem:" + getNome() + "vida:" + getValorVida();
    }
}
