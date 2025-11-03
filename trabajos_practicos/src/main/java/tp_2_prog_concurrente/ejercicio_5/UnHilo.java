package tp_2_prog_concurrente.ejercicio_5;

public class UnHilo implements Runnable {
    String nombreHilo;
    UnHilo(String nombre){
        nombreHilo=nombre;
    }
    //Punto de entrada del hilo
    //Los hilos comienzan a ejecutarse aquí
    public void run(){
        System.out.println("Comenzando "+nombreHilo);
        try {
            for (int contar=0; contar<10; contar++){
                Thread.sleep(400);
                System.out.println("En "+nombreHilo+", el recuento "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(nombreHilo + " Interrumpido.");
        } finally {

        }
        System.out.println("Terminando "+nombreHilo);
    }
}

