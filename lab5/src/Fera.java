public class Fera extends Personagem{
    public Fera(String nome){
        super(nome);
        setValorVida(100);
    }

    public int morder(){
        return 30;
    }
    public int usarGarra(){
        return 20;
    }

    public void atacar(Personagem adversario){
        if(Math.random() > 0.5){
            adversario.atualizarVida(this.morder());
        } else {
            adversario.atualizarVida(this.usarGarra());
        }
    }
}
