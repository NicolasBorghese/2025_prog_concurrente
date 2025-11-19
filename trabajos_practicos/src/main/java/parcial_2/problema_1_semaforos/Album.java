package parcial_2.problema_1_semaforos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Album {

    //ATRIBUTOS
    private String nombre;
    private int duracionTotal;
    private int duracionActual;
    private Queue<Cancion> canciones = new LinkedList<>();
    private Semaphore sem_agregarCancion = new Semaphore(0);
    private Semaphore sem_lanzarAlbum = new Semaphore(0);
    private Semaphore sem_puedeLanzarAlbum = new Semaphore(0);
    private Semaphore sem_agregarPrimerCancion = new Semaphore(0);

    public Album() {
        this.nombre = "Sin nombre";
        this.duracionTotal = 0;
        this.duracionActual = 0;
    }

    public void crearNuevoAlbum(String nombre, int duracion){
        this.nombre = nombre;
        this.duracionTotal = duracion;
        this.duracionActual = 0;
        this.sem_agregarPrimerCancion.release();
        System.out.println("Se a creado un nuevo album con el nombre: " + nombre+ ", con dureación total: "+ duracion);
    }

    public void agregarCancion(Cancion cancion, String nombreProductor){
        try {
            this.sem_agregarCancion.acquire();
            if(duracionActual + cancion.getDuracion() > duracionTotal){
                sem_puedeLanzarAlbum.release();
                sem_agregarPrimerCancion.acquire();
            }
            canciones.add(cancion);
            duracionActual += cancion.getDuracion();
            System.out.println("El productor " + nombreProductor + " agrego una canción al album: "+this.nombre);
            System.out.println("Duracion: " + duracionActual + "/" + duracionTotal);
            this.sem_agregarCancion.release();

        } catch(Exception e) {
            System.out.println("Error al agregar cancion");
        }
    }

    public void lanzarAlbum(){
        try {
            this.sem_lanzarAlbum.acquire();
            this.sem_puedeLanzarAlbum.acquire();
            int cantCanciones = this.canciones.size();
            System.out.println("El album: "+this.nombre+" fue lanzado con: "+cantCanciones+" canciones");
            this.nombre = "Sin nombre";
            this.duracionTotal = 0;
            this.duracionActual = 0;
            this.sem_lanzarAlbum.release();
        } catch (Exception e) {
            System.out.println("Error al lanzar album");
        }

    }
}
