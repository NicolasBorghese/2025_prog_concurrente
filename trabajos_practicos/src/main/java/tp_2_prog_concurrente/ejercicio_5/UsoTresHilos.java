package tp_2_prog_concurrente.ejercicio_5;

public class UsoTresHilos {
    public static void main(String[] args){
        System.out.println("Hilo principal iniciando.");

        UnHilo hilo1 = new UnHilo("Hilo #1");//Primero, construye un objeto UnHilo.
        Thread nuevoHilo1 = new Thread(hilo1);//Luego, construye un hilo de ese objeto

        UnHilo hilo2 = new UnHilo("Hilo #2");
        Thread nuevoHilo2 = new Thread(hilo2);

        UnHilo hilo3 = new UnHilo("Hilo #3");
        Thread nuevoHilo3 = new Thread(hilo3);

        nuevoHilo1.start();//Finalmente, comienza la ejecución del hilo
        nuevoHilo2.start();
        nuevoHilo3.start();

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
