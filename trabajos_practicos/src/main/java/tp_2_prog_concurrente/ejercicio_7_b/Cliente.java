package tp_2_prog_concurrente.ejercicio_7_b;

public class Cliente {
    private String nombre;
    private int[] carroCompra;

    // Constructor y métodos de acceso
    public Cliente(String nombre, int[] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int[] getCarroCompra() {
        return this.carroCompra;
    }
}


