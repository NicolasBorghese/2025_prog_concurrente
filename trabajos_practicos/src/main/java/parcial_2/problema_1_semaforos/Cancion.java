package parcial_2.problema_1_semaforos;

public class Cancion {

    //ATRIBUTOS
    private String nombre;
    private int duracion;
    private int tipo;

    public Cancion(String nombre, int duracion, int tipo) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public int getTipo() {
        return tipo;
    }

}
