package tp_3_sincronizacion.apunte_1;

public class GeneradorNros implements Runnable{
    private String nombre;
    private Contador cuenta;
    private int cantidad;

    public GeneradorNros(String nombre, Contador cuenta, int cantidad) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    public void run(){
        int totalNros = 0;
        double nroAleatorio;
        for(int i = 1; i <= cantidad; i++){
            nroAleatorio = Math.random() * 10;
            if (nroAleatorio >= 5 && nroAleatorio <= 6){
                System.out.println("En el hilo: "+nombre+" se generó el número QUE SI SUMA: "+ nroAleatorio);
                totalNros++;
            } else {
                System.out.println("En el hilo: "+nombre+" se generó el número: "+ nroAleatorio);
            }
        }
        cuenta.incrementar(totalNros);
        System.out.println("hilo "+nombre+" genero "+totalNros );
    }

}
