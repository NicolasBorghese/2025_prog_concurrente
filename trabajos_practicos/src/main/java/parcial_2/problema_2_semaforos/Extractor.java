package parcial_2.problema_2_semaforos;

public class Extractor implements Runnable{
    //ATRIBUTOS
    Buffer buffer;
    String nombre;

    //CONSTRUCTOR
    public Extractor(Buffer buffer, String nombre){
        this.buffer = buffer;
        this.nombre = nombre;
    }

    public void run() {

        while(true){
            this.buffer.extraer(this.nombre);
        }

    }
}
