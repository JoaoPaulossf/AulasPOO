import java.util.ArrayList;
import java.util.Random;

public class Gladiador extends Lutador{
    private ArrayList <Arma> armas = new ArrayList <> ();
    private ArrayList <Armadura> armaduras = new ArrayList <> ();
    private Random random = new Random();

    public Gladiador(String nome,Arma arma,Armadura armadura){
        super(nome);
        adicionarArma(arma);
        adicionarArmadura(armadura);
        vestirArmadura(armadura);
    }

    public ArrayList<Armadura> getArmaduras() {
        return armaduras;
    }
    
    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void vestirArmadura(Armadura armadura){
        setValorVida((getValorVida() + armadura.getPoderDefesa()));
    }

    // metodo em que é escolhido aleatoriamente dentre o arsenal do gladiador qual arma ele irá usar para desferir o ataque 
    private int usarArma(){ 
        if (armas == null || armas.isEmpty()) {
            System.out.println("Nenhuma arma disponível.");
            return 0;
        }
        int quantidadeArmas = armas.size();
        Arma armaEscolhida = armas.get(random.nextInt(quantidadeArmas));
        return armaEscolhida.atacar();
    }

    // metodo em que é escolhido aleatoriamente qual dos ataques irá usar(socar, chutar ou usar arma) como foi pedido no enunciado
    public void atacar(Personagem adversario){ 
        int escolha = random.nextInt(3) + 1;
        if(escolha == 1){
            adversario.atualizarVida(this.usarArma());
        }else if (escolha == 2){
            adversario.atualizarVida(this.socar());
        }else{
            adversario.atualizarVida(this.chutar());
        }
    }

    private void adicionarArma(Arma novaArma){
        armas.add(novaArma);
    }

    private void adicionarArmadura(Armadura  novaArmadura){
        armaduras.add(novaArmadura);
    }

    /*
        metodo utilizado para quando um gladiador derrotar um semelhante, ele pegar as suas armas
        decisão tomada para usar entre gladiadores, mas futuramente poderia ser expandido para as outras classes de lutadores um arsenal e adicionar aos mesmos este metodo
    */
    public void sacarAdversario(Gladiador adversario){
        ArrayList<Arma> armasAdversario = adversario.getArmas();
        ArrayList<Armadura> armadurasAdversario = adversario.getArmaduras();
        while(!armasAdversario.isEmpty()){
            Arma arma = armasAdversario.removeLast();
            armas.add(arma);
        }
        while(!armadurasAdversario.isEmpty()){
            Armadura armadura = armadurasAdversario.removeLast();
            armaduras.add(armadura);
        }
    }
    
    public void exibirPersonagem(){
        System.out.println(toString() + "\n\nArmas:");
        for(int i = 0; i < armas.size(); i++){
            armas.get(i).exibirArma();
        }
        System.out.println("\nArmaduras:");
        for(int i = 0; i < armaduras.size(); i++){
            armaduras.get(i).exibirArmadura();
        }
        System.out.println();
    }

    public String toString (){
        return "Nome do gladiador :" + getNome() + "Vida:" + getValorVida(); 
    }
}
