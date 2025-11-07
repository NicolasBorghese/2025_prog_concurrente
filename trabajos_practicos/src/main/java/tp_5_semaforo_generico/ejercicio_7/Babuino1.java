package tp_5_semaforo_generico.ejercicio_7;

public class Babuino1 implements Runnable {
    //ATRIBUTOS
    private String nombreBabuino;
    private String direccion;
    private Cuerda cuerda;
    private boolean pudoCruzar;

    public String getNombre(){
        return nombreBabuino;
    }

    public boolean getPudoCruzar(){
        return pudoCruzar;
    }

    public Babuino1(String nombreBabuino, String direccion, Cuerda cuerda) {
        this.nombreBabuino = nombreBabuino;
        this.direccion = direccion;
        this.cuerda = cuerda;
        this.pudoCruzar = false;
    }
    
    public void run() {
        cuerda.iniciarCruzarCuerda(this.direccion, this.nombreBabuino);
        cuerda.finalizarCruzarCuerda(this.direccion, this.nombreBabuino);
        pudoCruzar = true;
    }
}
