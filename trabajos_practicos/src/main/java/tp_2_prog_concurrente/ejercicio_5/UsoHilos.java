package tp_2_prog_concurrente.ejercicio_5;

public class UsoHilos {
    public static void main(String[] args){
        System.out.println("Hilo principal iniciando.");

        //Primero, construye un objeto UnHilo.
        UnHilo mh = new UnHilo("#1");

        //Luego, construye un hilo de ese objeto
        Thread nuevoHilo = new Thread(mh);

        //Finalmente, comienza la ejecución del hilo
        nuevoHilo.start();

        for(int i=0; i<50; i++){
            System.out.println(" . ("+i+")");
        }try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
