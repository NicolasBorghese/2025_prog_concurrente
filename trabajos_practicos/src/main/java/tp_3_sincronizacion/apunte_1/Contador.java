package tp_3_sincronizacion.apunte_1;

public class Contador {
    int valor;

    public Contador(){
        valor = 0;
    }

    public int getValor(){
        return valor;
    }

    public void setValor(int nro){
        this.valor = nro;
    }

    public void incrementar(){
        valor = valor +1;
    }

    public void incrementar(int incremento){
        valor = valor + incremento;
    }
}
