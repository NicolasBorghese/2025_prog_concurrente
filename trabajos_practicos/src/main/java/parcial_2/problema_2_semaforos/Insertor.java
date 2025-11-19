package parcial_2.problema_2_semaforos;

public class Insertor implements Runnable{

    //ATRIBUTOS
    Buffer buffer;
    int elemento;
    String nombre;

    //CONSTRUCTOR
    public Insertor(Buffer buffer, int elemento, String nombre){
        this.buffer = buffer;
        this.elemento = elemento;
        this.nombre = nombre;
    }

    public void run() {

        while(true){
            this.buffer.insertar(this.elemento, this.nombre);
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                System.out.println("Error al insertar");
            }
        }

    }
}