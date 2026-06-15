public class PixCredito extends Pix{
    protected double saldoCredito;

    public PixCredito (double saldoCredito){
        this.saldoCredito = saldoCredito;
    }

    public double pagarPix (double val){
        if(val <= saldoCredito){
            saldoCredito-= val;
            this.valor = val;
            return 0;
        }
        else{
            return 1;
        }
    }

    public double getSaldoCredito() {
        return saldoCredito;
    }
}
