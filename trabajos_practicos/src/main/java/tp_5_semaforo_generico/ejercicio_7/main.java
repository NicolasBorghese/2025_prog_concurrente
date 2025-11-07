package tp_5_semaforo_generico.ejercicio_7;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class main {
    /**
     * 1 - Hay 20 babuinos de cada lado de la cuerda
     * 2 - No se permite que se cruzen babuinos que van en distintas direcciones
     * 3 - Solo pueden pasar de a 5 babuinos a la vez
     *
     * Elementos identificados:
     *
     * 1 - CUERDA - Recurso compartido
     * I - Solo se habilita para máximo 5 babuinos a la vez.
     * O sea, controla cuantos babuinos estan cruzando a la vez
     * II - Cuando se habilita solo permite sumas babuinor que se dirijan en la misma
     * dirección.
     * O sea, controla la dirección a la que se dirigen los babuinos.
     *
     * 2 - BABUINO - Hilo / Recurso activo
     * I - Cuando inicia su tarea lo que único que intenta hacer es cruzar la cuerda
     */
    public static void main(String[] args) {

        Cuerda cuerda = new Cuerda();
        int cantBabuinosGen = 20;
        int cantBabuinos1 = cantBabuinosGen;
        int cantBabuinos2 = cantBabuinosGen;

        String direccion1 = "Derecha";
        String direccion2 = "Izquierda";

        Thread[] hilosBabuino1 = new Thread[cantBabuinos1];
        Thread[] hilosBabuino2 = new Thread[cantBabuinos2];

        for(int i = 0; i < cantBabuinos1; i++){
            String nombre1 = "PepePepePepe"+ i;
            Babuino babuino1 = new Babuino(nombre1, direccion1, cuerda);
            Thread hilo1 = new Thread(babuino1, nombre1);
            hilosBabuino1[i] = hilo1;
            //hilosBabuino1[i].start();
        }
        for(int j = 0; j < cantBabuinos2; j++){
            String nombre2 = "Jose"+ j;
            Babuino babuino2 = new Babuino(nombre2, direccion2, cuerda);
            Thread hilo2 = new Thread(babuino2, nombre2);
            hilosBabuino2[j] = hilo2;
            //hilosBabuino2[j].start();
        }

        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Error al dormir 1000");
        }

        int cruzados = 0;

        while( cruzados < cantBabuinosGen){
            Random rng = new Random();
            int aleatorio = rng.nextInt(1, 7);

            int limiteBabuinos = aleatorio + cruzados;

            if(limiteBabuinos > cantBabuinosGen){
                aleatorio = cantBabuinosGen - cruzados;
                limiteBabuinos = cantBabuinosGen;
            }

            System.out.println("Van a cruzar: "+aleatorio+" babuinos de cada lado de: "+cantBabuinosGen);

            if(limiteBabuinos > cantBabuinosGen){
                limiteBabuinos = cantBabuinosGen;
            }

            for(int contador = cruzados; cruzados < limiteBabuinos; contador++ ){
                cruzados++;
                hilosBabuino1[contador].start();
                hilosBabuino2[contador].start();
            }

            try {
                //Thread.sleep(3000);
                //System.out.println("Terminaron de cruzar: "+aleatorio+" babuinos de cada lado. Total: "+limiteBabuinos);
            }catch (Exception e){
                System.out.println("Error al dormir 3000");
            }
        }

        for(int i = 0; i < cantBabuinos1; i++){
            try{
                hilosBabuino1[i].join();
                String nombre1 = hilosBabuino1[i].getName();
                System.out.println("El babuino: "+nombre1+" cruzo al otro lado");
            }catch(Exception e){
                System.out.println("Error join babuinos 1");
            }
        }

        for(int j = 0; j < cantBabuinos2; j++){
            try{
                hilosBabuino2[j].join();
                String nombre2 = hilosBabuino2[j].getName();
                System.out.println("El babuino: "+nombre2+" cruzo al otro lado");
            }catch(Exception e){
                System.out.println("Error join babuinos 2");
            }
        }

        System.out.println("Todos los babuinos cruzaron hacia el otro lado");


    }
}

