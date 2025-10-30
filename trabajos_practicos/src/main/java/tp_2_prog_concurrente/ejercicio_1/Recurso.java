package tp_2_prog_concurrente.ejercicio_1;

public class Recurso {
    static void uso(){
        Thread t = Thread.currentThread();
        System.out.println("en recurso: soy " + t.getName());
        //System.out.println("Info completa: " + t);
    }
}
