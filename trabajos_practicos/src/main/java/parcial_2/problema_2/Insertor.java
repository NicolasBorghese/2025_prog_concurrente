package parcial_2.problema_2;

public class Insertor implements Runnable{
    //ATRIBUTOS
    Buffer buffer;
    int elemento;
    String nombreInsertor;

    //CONSTRUCTOR
    public Insertor(Buffer buffer, int elemento, String nombreInsertor) {
        this.buffer = buffer;
        this.elemento = elemento;
        this.nombreInsertor = nombreInsertor;
    }

    public void run (){

        while(true){
            this.buffer.insertarElemento(this.elemento, this.nombreInsertor);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println("Error");
            }
        }
    }
}
