package tp_2_prog_concurrente.ejercicio_2;

public class TesteoHilos {
    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        System.out.println("En el main");
    }
}
