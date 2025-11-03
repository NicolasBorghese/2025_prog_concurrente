package tp_2_prog_concurrente.ejercicio_5;

public class UnHiloThread extends Thread{
    private String nombreHilo;

    public UnHiloThread(String nombreHilo){
        this.nombreHilo = nombreHilo;
    }

    public void run(){
        System.out.println("Comenzando "+nombreHilo);
        try {
            for (int contar=0; contar<10; contar++){
                Thread.sleep(400);
                System.out.println("En "+nombreHilo+", el recuento "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(nombreHilo + " Interrumpido.");
        }
        System.out.println("Terminando "+nombreHilo);
    }
}
