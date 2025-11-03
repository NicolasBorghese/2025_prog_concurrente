package tp_2_prog_concurrente.ejercicio_8;

public class MainRun {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5,
                2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1,
                1});

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        CajeroRun cajero1 = new CajeroRun("Cajero 1", cliente1, initialTime);
        CajeroRun cajero2 = new CajeroRun("Cajero 2", cliente2, initialTime);

        Thread hilo1 = new Thread(cajero1);
        Thread hilo2 = new Thread(cajero2);

        hilo1.start();
        hilo2.start();
    }
}
