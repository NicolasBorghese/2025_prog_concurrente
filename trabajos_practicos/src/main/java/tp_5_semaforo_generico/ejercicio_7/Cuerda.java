package tp_5_semaforo_generico.ejercicio_7;

import java.util.concurrent.Semaphore;

public class Cuerda {
    private final int CAPACIDAD = 5;
    private int enCuerda = 0;
    private String direccionActual = null;

    // controla el acceso al recurso compartido (exclusión mutua)
    private final Semaphore mutex = new Semaphore(1);

    // controla la capacidad de la cuerda (máx. 5 babuinos)
    private final Semaphore semCapacidad = new Semaphore(CAPACIDAD);

    // controla el cambio de dirección (bloquea babuinos de la dirección contraria)
    private final Semaphore semCambioDireccion = new Semaphore(1);

    public void iniciarCruzarCuerda(String direccion, String nombre) {
        try {
            while (true) {
                mutex.acquire();

                // Si la cuerda está libre, asigno la dirección
                if (direccionActual == null) {
                    direccionActual = direccion;
                }

                // Si la dirección coincide, puedo cruzar
                if (direccionActual.equals(direccion)) {
                    enCuerda++;
                    if (enCuerda == 1) {
                        // El primero en entrar bloquea el cambio de dirección
                        semCambioDireccion.acquire();
                    }
                    mutex.release();
                    break; // salgo del while, puedo cruzar
                } else {
                    // Dirección opuesta, no puedo cruzar aún
                    mutex.release();
                    Thread.sleep(10); // espero un poco y reintento
                }
            }

            // Esperar turno por capacidad
            semCapacidad.acquire();

            System.out.println(nombre + " empezó a cruzar hacia " + direccion +
                    " (total en cuerda: " + enCuerda + ")");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void finalizarCruzarCuerda(String direccion, String nombre) {
        try {
            // Libero mi lugar en la cuerda
            semCapacidad.release();

            mutex.acquire();
            enCuerda--;

            System.out.println(nombre + " terminó de cruzar hacia " + direccion +
                    " (quedan: " + enCuerda + ")");

            // Si fui el último, libero el cambio de dirección
            if (enCuerda == 0) {
                direccionActual = null;
                semCambioDireccion.release();
            }

            mutex.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
