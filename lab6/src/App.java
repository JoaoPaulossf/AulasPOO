public class App {
    public static void main(String[] args) throws Exception {
        Pix pagamentoA = new Pix ();
        PixCredito pagamentoB = new PixCredito(1000);
        PixAgendado pagamentoC = new PixAgendado(1000);

        pagamentoA.pagarPix(100);
        System.out.println("Transferência PIX realizada com sucesso!\nValor:R$" + pagamentoA.getValor());
        if(pagamentoB.pagarPix(2000) == 1){
            System.out.println("Valor acima do limite para PIX em crédito!\nLimite:R$" + pagamentoB.getSaldoCredito());
        }else{
            System.out.println("Transferência em Crédito realizada com sucesso!\nValor:R$" + pagamentoB.getValor());
        }
        if (pagamentoC.pagarPix(600) == 1) {
            System.out.println("Valor acima do limite para PIX agendado!\nLimite:R$" + pagamentoC.getLimiteAgendamento());
        }else{
            System.out.println("Transferência Agendada realizada com sucesso!\nValor:R$" + pagamentoC.getValor());
        }
    }
}
