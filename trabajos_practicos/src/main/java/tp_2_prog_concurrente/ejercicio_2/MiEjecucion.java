package tp_2_prog_concurrente.ejercicio_2;

public class MiEjecucion extends Thread{
    public void run(){
        ir();
    }
    public void ir(){
        hacerMas();
    }
    public void hacerMas(){
        System.out.println("Estoy en la pila");
    }
}
