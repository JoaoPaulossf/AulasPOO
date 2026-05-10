public class Sequencial {

    private static int contador = 0;
    public static String getSequencia(){
        if (contador > 999){
            contador = 0;
        }

        String sequencia = String.format("%03d", contador);
        contador++;

        return sequencia;
    }
}
