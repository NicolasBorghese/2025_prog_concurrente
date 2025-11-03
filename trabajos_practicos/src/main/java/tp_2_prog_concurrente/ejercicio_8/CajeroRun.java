package tp_2_prog_concurrente.ejercicio_8;

public class CajeroRun implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    // Constructor, y métodos de acceso

    public CajeroRun(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public void run() {
        System.out.println("El cajero " + this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + "->Tiempo: " +
                    (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
        }
        System.out.println("El cajero" + this.nombre + " HA TERMINADO DE PROCESAR "+ this.cliente.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
    }

    public void esperarXsegundos(int tiempoEscaner){
        try{
            int tiempo = tiempoEscaner * 1000;
            Thread.sleep(tiempo);
        }catch(InterruptedException e){

        }
    }
}

