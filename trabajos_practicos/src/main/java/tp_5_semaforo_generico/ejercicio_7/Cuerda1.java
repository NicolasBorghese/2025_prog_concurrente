package tp_5_semaforo_generico.ejercicio_7;

import java.util.concurrent.Semaphore;

/**
 * 1 - CUERDA - Recurso compartido
 * I - Solo se habilita para máximo 5 babuinos a la vez.
 * O sea, controla cuantos babuinos estan cruzando a la vez
 * II - Cuando se habilita solo permite sumas babuinor que se dirijan en la misma
 * dirección.
 * O sea, controla la dirección a la que se dirigen los babuinos.
 */
public class Cuerda1 {
    //ATRIBUTOS
    private final int capMaxima = 5;
    private int cantBabuinos;
    private String direccion;
    private Semaphore sem_cantBabuinos = new Semaphore(5);
    private Semaphore sem_mod_cantBabuinos = new Semaphore(1);
    private Semaphore sem_direccion = new Semaphore(1);
    private Semaphore sem_control_inicio = new Semaphore(1);
    private Semaphore sem_control_fin = new Semaphore(1);

    public Cuerda1(){
        this.direccion = "";
        this.cantBabuinos = 0;
    }

    public void iniciarCruzarCuerda(String direccion, String nombreBabuino){
        try{
            sem_direccion.acquire();
            if (this.direccion.equals("")){
                this.direccion = direccion;
            }
            if (!this.direccion.equals(direccion) && cantBabuinos == 0){
                this.direccion = direccion;
            }
            if(!this.direccion.equals(direccion) && cantBabuinos > 0){
                sem_control_inicio.acquire();
            }
            sem_direccion.release();

            if(cantBabuinos < capMaxima && this.direccion.equals(direccion)){
                sem_cantBabuinos.acquire();
                sem_mod_cantBabuinos.acquire();
                this.cantBabuinos++;
                sem_mod_cantBabuinos.release();
                System.out.println("El babuino: "+nombreBabuino+" empezó a cruzar hacia la: "+ direccion
                +" con "+this.cantBabuinos+" babuinos en la cuerda");
            } else {
                sem_direccion.acquire();
                System.out.println("El babuino: "+nombreBabuino+" empezó a cruzar hacia la: "+ direccion
                        +" con "+this.cantBabuinos+" babuinos en la cuerda");


            }
        } catch( InterruptedException e){
            System.out.println("Error al empezar a cruzar la cuerda");
        }
    }

    public void finalizarCruzarCuerda(String direccion, String nombreBabuino){
        try{
            sem_control_fin.acquire();
            System.out.println("El babuino: "+nombreBabuino+" terminó de cruzar hacia la: "+ direccion
                    +" con "+this.cantBabuinos+" babuinos en la cuerda");
            sem_mod_cantBabuinos.acquire();
            this.cantBabuinos--;
            sem_mod_cantBabuinos.release();
            sem_cantBabuinos.release();
            if(!this.direccion.equals(direccion) && cantBabuinos == 0){
                sem_control_inicio.release();
            }
            sem_control_fin.release();
        } catch( InterruptedException e){
            System.out.println("Error al finalizar de cruzar la cuerda");
        }
    }
}
