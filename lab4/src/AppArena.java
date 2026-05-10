
import java.util.ArrayList;
import java.util.Random;

public class AppArena {
    static int qtdLutadores = 0;
    static int qtdFeras = 0;
    static int qtdGladiadores = 0;
    private Random random = new Random();
    private ArrayList <Personagem> personagens = new ArrayList<>();

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    /*
        metodos auxiliares para aleatorizar os equipamentos iniciais de cada gladiador
    */
    private Arma gerarArmaAleatoria() {
        int escolha = random.nextInt(3) + 1;
        switch (escolha) {
            case 1:
                Arma espada = new Arma("Espada");
                espada.adicionarGolpe(new Golpe("Corte", 20));
                espada.adicionarGolpe(new Golpe("Estocada", 15));
                return espada;

            case 2:
                Arma machado = new Arma("Machado");
                machado.adicionarGolpe(new Golpe("Machadada", 25));
                machado.adicionarGolpe(new Golpe("Golpe Vertical", 18));
                return machado;

            case 3:
                Arma lanca = new Arma("Lança");
                lanca.adicionarGolpe(new Golpe("Perfuração", 22));
                lanca.adicionarGolpe(new Golpe("Investida", 17));
                return lanca;

            default:
                return null;
        }
    }

    private Armadura gerarArmaduraAleatoria() {
        int escolha = random.nextInt(3) + 1;

        switch (escolha) {
            case 1:
                Armadura armaduraPano = new Armadura(30,"Pano");
                return armaduraPano;

            case 2:
                Armadura armaduraCouro = new Armadura(70,"Couro");
                return armaduraCouro;

            case 3:
                Armadura armaduraFerro = new Armadura(120,"Ferro");
                return armaduraFerro;
            default:
                return null;
        }
    }

    //construtor
    public AppArena(int quantidadePersonagens){
        for(int i = 0; i < quantidadePersonagens; i++){
            int escolha = random.nextInt(3) + 1;
            if(escolha == 1){
                Lutador lutador = new Lutador("lutador nº" + (qtdLutadores+1));
                personagens.add(lutador);
                qtdLutadores++;
            }else if(escolha == 2){
                Fera fera = new Fera("fera nº" + (qtdFeras+1));
                personagens.add(fera);
                qtdFeras++;
            }else{
                Arma arma = gerarArmaAleatoria();
                Armadura armadura = gerarArmaduraAleatoria();
                Gladiador gladiador = new Gladiador("Gladiador nº" + (qtdGladiadores+1), arma, armadura);
                personagens.add(gladiador);
                qtdGladiadores++;
            }
        }
    }
    
    // Metodo para realizar os duelos entre dois personagens, retorna o vencedor do duelo
    public Personagem iniciarCombate(Personagem personagem1, Personagem personagem2){
        System.out.println("\nLutadores:");
        personagem1.exibirPersonagem();
        personagem2.exibirPersonagem();
        int turno = 1;
        while(personagem1.estaVivo() && personagem2.estaVivo()){
            Personagem atacante, defensor;
            if((turno % 2) == 0 ){
                atacante = personagem1;
                defensor = personagem2;
            }else{
                atacante = personagem2;
                defensor = personagem1;
            }
            atacante.atacar(defensor);
            System.out.println("O " + atacante.getNome() + " desferiu um golpe no " + defensor.getNome() + " que ficou com " + defensor.getValorVida() + " pontos de vida ");
            turno++;
        }
        if(personagem1.estaVivo()){
            if(personagem1.ehGladiador() && personagem2.ehGladiador()){
                Gladiador g1 = (Gladiador) personagem1;
                Gladiador g2 = (Gladiador) personagem2;
                g1.sacarAdversario(g2);
            }
            System.out.println(personagem1.getNome() + " venceu!");
            return personagem1;
        }
        if(personagem1.ehGladiador() && personagem2.ehGladiador()){
            Gladiador g1 = (Gladiador) personagem1;
            Gladiador g2 = (Gladiador) personagem2;
            g2.sacarAdversario(g1);
        }
        System.out.println(personagem2.getNome() + " venceu!");
        return personagem2;
    }

    // Metodo para a realização do torneio, retorna o vencedor do torneio
    public Personagem torneio(){
        int rodada = 1;
        while(personagens.size() > 1){
            System.out.println("\n--- Rodada " + rodada + " ---");
            ArrayList<Personagem> vencedores = new ArrayList<>();
            for(int i = 0; i < personagens.size(); i += 2){

                /*
                    Verificação realizada para saber se há algum personagem que ficou sem dupla para duelar,
                    adicionando ele diretamente na lista dos vencedores da respectiva rodada
                */
                if(i == personagens.size() - 1) { 
                    Personagem solitario = personagens.get(i);
                    
                    System.out.println(solitario.getNome() + " avançou automaticamente para a proxima rodada por não ter oponente!");
                    
                    vencedores.add(solitario);
                }else{
                    Personagem p1 = personagens.get(i);
                    Personagem p2 = personagens.get(i+1);
    
                    System.out.println(p1.getNome() + " VS " + p2.getNome());
    
                    Personagem vencedor = iniciarCombate(p1, p2);
    
                    vencedores.add(vencedor);
                }
            }
            personagens = vencedores;
            rodada++;
        }
        return personagens.get(0);
    }
    public static void main(String[] args){
        AppArena app = new AppArena(10);
        Personagem vencedor = app.torneio();
        System.out.println(vencedor.getNome() + " ganhou o torneio!!!");
        vencedor.exibirPersonagem();
    }
}
