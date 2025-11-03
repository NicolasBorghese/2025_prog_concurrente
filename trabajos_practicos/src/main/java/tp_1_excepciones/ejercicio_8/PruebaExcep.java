package tp_1_excepciones.ejercicio_8;

public class PruebaExcep extends Throwable{
    public PruebaExcep(String mensaje){
        super(mensaje);
    }

    /**
     * a - Escriba un método que ingrese la edad de una persona y dispare una
     * excepción si la persona es menor de edad.
     * */
    public static boolean esMayorEdad(int edad) throws PruebaExcep{
        if(edad < 18){
            throw new PruebaExcep("Error, es menor de edad");
        }
        return true;
    }

    /**
     * Escriba un método que ingrese un numero de la ruleta y dispare una
     * excepción cuando al jugar no salga dicho número.
     */
    public static boolean acertoNumeroGanador(int numeroElegido, int numeroGanador) throws PruebaExcep{
        if(numeroElegido != numeroGanador) {
            throw new PruebaExcep("Error, el numero elegido no es el numero ganador");
        }
        return true;
    }

    /**
     * Escriba un método en el que se pida ingresar 5 números a una colección y al
     * mostrarlos, trate de mostrar 7 valores de la misma, generando una excepción.
     */

}
