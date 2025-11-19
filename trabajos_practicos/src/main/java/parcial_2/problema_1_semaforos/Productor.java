package parcial_2.problema_1_semaforos;

public class Productor implements Runnable{

    //ATRIBUTOS
    private Mesa mesa;
    private Album album;
    private String nombre;
    private int tipo;

    //CONSTRUCTOR
    public Productor(Mesa mesa, Album album, String nombre, int tipo){
        this.mesa = mesa;
        this.album = album;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void run(){
        while(true){
            Cancion nuevaCancion = mesa.retirarCancion(this.tipo, this.nombre);
            this.album.agregarCancion(nuevaCancion, this.nombre);
        }
    }
}
