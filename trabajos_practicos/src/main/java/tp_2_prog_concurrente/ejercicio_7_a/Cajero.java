package tp_2_prog_concurrente.ejercicio_7_a;

public class Cajero {
    private String nombre;
    // Agregar Constructor, y métodos de acceso

    public Cajero(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println ("El cajero " + this.nombre +" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
                    "->Tiempo: " + (System.currentTimeMillis() - timeStamp) /
                    1000 + "seg");
        }
        System.out.println("El cajero " + this.nombre +" HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +
        (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    public void esperarXsegundos(int tiempoEscaner){
        try{
            int tiempo = tiempoEscaner * 1000;
            Thread.sleep(tiempo);
        }catch(InterruptedException e){

        }
    }
}

