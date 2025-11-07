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
public class Cuerda2 {
    //ATRIBUTOS
    private final int capMaxima = 5;
    private int contBabuinos;
    private String direccion;
    private boolean esperaCambioDir;
    private Semaphore sem_cant = new Semaphore(5);
    private Semaphore sem_controlCambioDir = new Semaphore(1);
    private Semaphore sem_direccion = new Semaphore(0);
    private Semaphore sem_iniciar = new Semaphore(1);
    private Semaphore sem_finalizar = new Semaphore(1);

    public Cuerda2(){
        this.contBabuinos = 0;
        this.direccion = "";
        this.esperaCambioDir = false;
    }

    public void iniciarCruzarCuerda(String direccion, String nombreBabuino){
        try{
            sem_iniciar.acquire();
            if(this.direccion.equals("")){
                this.direccion = direccion;
            }
            if(this.direccion.equals(direccion)){
                sem_cant.acquire();
                this.contBabuinos++;
            } else {
                sem_controlCambioDir.acquire();
                esperaCambioDir = true;
                sem_controlCambioDir.release();
                sem_direccion.acquire();
            }
            sem_iniciar.release();
            System.out.println("El babuino: "+nombreBabuino+" empezó a cruzar hacia la: "+ direccion
                    +" con "+this.contBabuinos+" babuinos en la cuerda");
        } catch(Exception e){
            System.out.println("Error al empezar a cruzar la cuerda");
        }
    }

    public void finalizarCruzarCuerda(String direccion, String nombreBabuino){
        try{
            sem_finalizar.acquire();
            this.contBabuinos--;
            System.out.println("El babuino: "+nombreBabuino+" terminó de cruzar hacia la: "+ direccion
                    +" con "+this.contBabuinos+" babuinos en la cuerda");
            if(this.contBabuinos == 0 && esperaCambioDir){
                sem_controlCambioDir.acquire();
                esperaCambioDir = false;
                sem_controlCambioDir.release();
                sem_direccion.release();
            }
            sem_cant.release();
            sem_finalizar.release();
        } catch(Exception e){
            System.out.println("Error al finalizar de cruzar la cuerda");
        }
    }
}
