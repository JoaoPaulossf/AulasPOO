

import java.util.Random;

public class Lutador extends Personagem{
    
    private Random random = new Random();

    public Lutador(String nome){
        super(nome);
    }

    public int chutar(){
        return 20;
    }

    public int socar(){
        return 10;
    }

    public void atacar(Personagem adversario){
        if(Math.random() > 0.5){
            adversario.atualizarVida(this.chutar());
        } else {
            adversario.atualizarVida(this.socar());
        }
    }

    public int esquivar(int ataqueSofrido){
        // caso queira esquivar, haverá a chance de não receber nenhum dano(esquivou) ou tomar o dano completo
        int chanceEsquiva = random.nextInt(100) +1;
        if (chanceEsquiva <= 40){
            return 0;
        }
        return ataqueSofrido;
    }

    public int fazerGuarda(int ataqueSofrido){
        int danoSofrido = ataqueSofrido / 2; // ao receber o ataque se defendendo, recebe metade do dano
        return danoSofrido;
    }

    public void defender(int poderOfensivo){
        int escolha = random.nextInt(3);
        if(escolha == 0){
            this.atualizarVida(this.esquivar(poderOfensivo));
        }else if(escolha == 1){
            this.atualizarVida(this.fazerGuarda(poderOfensivo));
        }else{
            this.atualizarVida(poderOfensivo);
        }
    }

    public String toString (){
        return "Nome do lutador:" + getNome() + "Vida:" + getValorVida(); 
    }
}
