package parcial_2.problema_2;

public class Extractor implements Runnable{
    //ATRIBUTOS
    Buffer buffer;
    String nombreExtractor;

    //CONSTRUCTOR
    public Extractor(Buffer buffer, String nombreExtractor) {
        this.buffer = buffer;
        this.nombreExtractor = nombreExtractor;
    }

    public void run() {

        while (true){
            this.buffer.extraerElemento(this.nombreExtractor);
        }
    }

}
