package tp_1_excepciones.ejercicio_8;

public class DivideByZeroException extends ArithmeticException{
    public DivideByZeroException(String message){
        super(message);
    }

    public double dividir(int num, int den) throws
            DivideByZeroException {
        if (den ==0)
            throw new DivideByZeroException("Error!!!!!!!");
        return((double) num / (double)den);
    }
}