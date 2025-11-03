package tp_3_sincronizacion.apunte_1;

public class TestGenerador {
    public static void main(String[] args) {
        Contador elContador = new Contador();
        GeneradorNros genera1, genera2;
        Thread hilo1, hilo2;

        genera1 = new GeneradorNros("soyGen_1", elContador, 20);
        hilo1 = new Thread(genera1);
        genera2 = new GeneradorNros("soyGen_2", elContador, 20);
        hilo2 = new Thread(genera2);

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Total de números generados por los hilos "+elContador.getValor());
    }
}
