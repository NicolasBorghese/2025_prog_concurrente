package tp_5_semaforo_generico.ejercicio_7;

public class Babuino implements Runnable {
    private String nombreBabuino;
    private String direccion;
    private Cuerda cuerda;
    private boolean pudoCruzar;

    public Babuino(String nombreBabuino, String direccion, Cuerda cuerda) {
        this.nombreBabuino = nombreBabuino;
        this.direccion = direccion;
        this.cuerda = cuerda;
        this.pudoCruzar = false;
    }

    public void run() {
        cuerda.iniciarCruzarCuerda(this.direccion, this.nombreBabuino);

        // 🔸 Simula tiempo real cruzando (entre 0.5 y 2 segundos)
        try {
            Thread.sleep((long) (500 + Math.random() * 1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cuerda.finalizarCruzarCuerda(this.direccion, this.nombreBabuino);
        pudoCruzar = true;
    }
}
