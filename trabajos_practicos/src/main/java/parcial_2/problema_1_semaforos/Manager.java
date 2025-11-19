package parcial_2.problema_1_semaforos;

import java.util.Random;

public class Manager implements Runnable{

    //ATRIBUTOS
    private String nombre;
    private Album album;

    //CONSTRUCTOR
    public Manager(String nombre, Album album){
        this.nombre = nombre;
        this.album = album;
    }

    public void run(){

        Random random = new Random();

        while(true){

            String nombreAlbum = "NUEVOALBUM";
            int duracionAlbum = random.nextInt(2000, 4000);

            this.album.crearNuevoAlbum(nombreAlbum, duracionAlbum);

            this.album.lanzarAlbum();

            try {
                Thread.sleep(5000);
            } catch(Exception e) {
                System.out.println("Error luego de lanzar album");
            }
        }
    }
}
