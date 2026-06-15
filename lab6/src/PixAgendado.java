public class PixAgendado extends Pix{
    protected double limiteAgendamento;

    public PixAgendado (double limiteAgendamento){
        this.limiteAgendamento = limiteAgendamento;
    }

    public double pagarPix (double val){
        if(val <= limiteAgendamento){
            limiteAgendamento -= val;
            this.valor = val;
            return 0;
        }else {
            return 1;
        }
    }

    public double getLimiteAgendamento() {
        return limiteAgendamento;
    }
}
