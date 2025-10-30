package tp_2_prog_concurrente.ejercicio_4;

public class ThreadEjemploRunnable implements Runnable{
    private String nombre;

    public ThreadEjemploRunnable(String nombre){
        this.nombre = nombre;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + nombre);
        }
        System.out.println("Termina thread " + nombre);
    }

    public static void main(String[] args){
        Thread t1 = new Thread(new ThreadEjemploRunnable("Maria Jose"));
        Thread t2 = new Thread(new ThreadEjemploRunnable("Jose Maria"));

        t1.start();
        t2.start();

        System.out.println("Termina thrad main");
    }
}
