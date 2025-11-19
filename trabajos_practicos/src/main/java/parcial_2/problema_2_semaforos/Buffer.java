package parcial_2.problema_2_semaforos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {

    private Queue<Integer> colaExtraer = new LinkedList<Integer>();
    private Queue<Integer> colaInsertar = new LinkedList<Integer>();
    private Semaphore sem_insertar = new Semaphore(1);
    private Semaphore sem_extraer = new Semaphore(1);
    private Semaphore sem_puedeExtraer = new Semaphore(0);
    private Semaphore sem_intercambio = new Semaphore(1);

    public void insertar(int elemento, String nombre) {

        try{
            sem_insertar.acquire();
            System.out.println(nombre +" Insertando: " + elemento);
            colaInsertar.add(elemento);
            sem_puedeExtraer.release();
            sem_insertar.release();
        }catch(Exception e){
            System.out.println("Error al insertar");
        }

    }

    public int extraer(String nombre){

        int elemento = 0;

        try{
            sem_puedeExtraer.acquire();
            sem_extraer.acquire();

            if (colaExtraer.isEmpty() && !colaInsertar.isEmpty()){
                sem_insertar.acquire();
                this.intercambiarColas();
                System.out.println(nombre +" cambio las colas");
                elemento = colaExtraer.poll();
                System.out.println(nombre +" extrayendo: " + elemento);
                sem_insertar.release();
            } else if (!colaExtraer.isEmpty()){
                elemento = colaExtraer.poll();
                System.out.println(nombre +" extrayendo: " + elemento);
            }
            sem_extraer.release();
        }catch(Exception e){
            System.out.println("Error al extraer: "+ e.getMessage());
        }

        return elemento;
    }

    public void intercambiarColas(){
        try{
            sem_intercambio.acquire();
            Queue<Integer> aux = colaExtraer;
            colaExtraer = colaInsertar;
            colaInsertar = aux;
            sem_intercambio.release();
        }catch(Exception e){
            System.out.println("Error al intercambiar las colas");
        }

    }
}
