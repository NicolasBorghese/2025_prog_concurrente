package tp_2_prog_concurrente.apunte_1;

public class TestAlfaBeta {
    public static void main(String[] args) {
        HiloAlfaBeta alfa = new HiloAlfaBeta("Hilo Alfa", 8);
        HiloAlfaBeta beta = new HiloAlfaBeta("Hilo Beta", 2);

        alfa.setPriority(Thread.MIN_PRIORITY); // valor 1
        beta.setPriority(Thread.MAX_PRIORITY); // valor 10

        alfa.start();
        beta.start();

        System.out.println("Probando hilos");
    }
}
