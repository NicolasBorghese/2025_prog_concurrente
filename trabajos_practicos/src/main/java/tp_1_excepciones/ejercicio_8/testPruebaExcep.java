package tp_1_excepciones.ejercicio_8;

import utiles.TecladoIn;

import java.util.concurrent.ThreadLocalRandom;

public class testPruebaExcep {

    public static void main(String[] args) throws PruebaExcep {

        System.out.print("Ingrese una edad: ");
        int edad = TecladoIn.readLineInt();

        try {
            boolean esMayor = PruebaExcep.esMayorEdad(edad);
            if(esMayor) {
                System.out.println("Es Mayor");
            }
        } catch (PruebaExcep e) {
            System.out.println("Catch: Es menor de edad");
        }

        System.out.println("Ingrese un numero para apostar a la ruleta");
        int numeroElegido = TecladoIn.readLineInt();

        try {
            int numeroGanador = ThreadLocalRandom.current().nextInt(0, 36);
            System.out.println("El numemro ganador es: " + numeroGanador);
            boolean acertoNumero = PruebaExcep.acertoNumeroGanador(numeroElegido, numeroGanador);
        } catch (PruebaExcep e) {
            System.out.println("Catch: No se acerto al numero ganador");
        }

        System.out.print("Ingrese una nueva edad: ");
        int edad2 = TecladoIn.readLineInt();

        boolean esMayor = PruebaExcep.esMayorEdad(edad);

        System.out.println("Programa finalizado con exito.");
    }
}
