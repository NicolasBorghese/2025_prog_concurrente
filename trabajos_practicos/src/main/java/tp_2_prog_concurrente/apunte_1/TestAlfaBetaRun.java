package tp_2_prog_concurrente.apunte_1;

public class TestAlfaBetaRun {
    public static void main(String[] args) {
        RunnableAlfaBeta alfaBetaRunnable_1 = new RunnableAlfaBeta(8);
        RunnableAlfaBeta alfabetaRunnable_2 = new RunnableAlfaBeta(4);

        Thread alfa = new Thread(alfaBetaRunnable_1, "Hilo Alfa");
        Thread beta = new Thread(alfabetaRunnable_2, "Hilo Beta");

        alfa.start();
        beta.start();
        System.out.println("Estoy saliendo del main");
    }
}
