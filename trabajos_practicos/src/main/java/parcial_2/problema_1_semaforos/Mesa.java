package parcial_2.problema_1_semaforos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Mesa {

    //ATRIBUTOS
    private int cantGeneros = 4;
    private Queue<Cancion>[] canciones = new Queue[cantGeneros];
    private Semaphore[] col_sem_canciones = new Semaphore[cantGeneros];
    private Semaphore retirarCancion = new Semaphore(1);
    private Semaphore colocarCancion = new Semaphore(1);

    //CONSTRUCTOR
    public Mesa(){
        for(int i=0; i<cantGeneros; i++){
            canciones[i] = new LinkedList<>();
            col_sem_canciones[i] = new Semaphore(0);
        }
    }

    public void colocarCancion(Cancion nuevaCancion, String nombreAutor){

        try{
            colocarCancion.acquire();
            int tipoCancion = nuevaCancion.getTipo();
            canciones[tipoCancion].add(nuevaCancion);
            System.out.println("El autor "+nombreAutor+" a dejado una cancion de tipo: "+ tipoCancion+" sobre la mesa");
            col_sem_canciones[tipoCancion].release();
            colocarCancion.release();

        } catch(Exception e){
            System.out.println("Error en colocarCancion");
        }

    }

    public Cancion retirarCancion(int tipoCancion, String nombreProductor){

        Cancion cancion = null;

        try{
            retirarCancion.acquire();
            col_sem_canciones[tipoCancion].acquire();
            cancion = canciones[tipoCancion].poll();
            System.out.println("El productor "+nombreProductor+" a retirado una canción de tipo: "+ tipoCancion+" de la mesa");
            retirarCancion.release();

        } catch (Exception e){
            System.out.println("Error en retirarCancion");
        }

        return cancion;
    }
}
