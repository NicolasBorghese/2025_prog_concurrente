package tp_2_prog_concurrente.apunte_1;

public class HiloAlfaBeta extends Thread {
    int cantidad;

    public HiloAlfaBeta(String nombre, int laCantidad){
        super(nombre);
        this.cantidad = laCantidad;
    }

    public void run(){
        for (int i = 1; i <= this.cantidad; i++){
            System.out.println(this.getName() + " En ejecucion");
            System.out.println(Thread.currentThread() + "------" + Thread.currentThread().getName());
        }
    }
}
