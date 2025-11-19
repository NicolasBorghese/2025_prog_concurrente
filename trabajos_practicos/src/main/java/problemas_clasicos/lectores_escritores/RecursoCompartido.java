package problemas_clasicos.lectores_escritores;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RecursoCompartido {
    private int lectoresActivos = 0;       // cantidad de lectores que están leyendo
    private int escritoresEsperando = 0;   // cantidad de escritores esperando
    private boolean escribiendo = false;   // indica si hay un escritor escribiendo

    private final Lock lock = new ReentrantLock();
    private final Condition puedeLeer = lock.newCondition();
    private final Condition puedeEscribir = lock.newCondition();

    // --- ENTRAR COMO LECTOR ---
    public void empezarLeer(String nombre) throws InterruptedException {
        lock.lock();
        try {
            while (escribiendo || escritoresEsperando > 0) {
                // Espera si hay alguien escribiendo o un escritor esperando (política justa)
                System.out.println(nombre + " espera para leer...");
                puedeLeer.await();
            }
            lectoresActivos++;
            System.out.println(nombre + " empieza a leer. Lectores activos: " + lectoresActivos);
        } finally {
            lock.unlock();
        }
    }

    // --- SALIR COMO LECTOR ---
    public void terminarLeer(String nombre) {
        lock.lock();
        try {
            lectoresActivos--;
            System.out.println(nombre + " terminó de leer. Lectores activos: " + lectoresActivos);
            if (lectoresActivos == 0) {
                // Si no quedan lectores, despierta a un escritor
                puedeEscribir.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    // --- ENTRAR COMO ESCRITOR ---
    public void empezarEscribir(String nombre) throws InterruptedException {
        lock.lock();
        try {
            escritoresEsperando++;
            while (lectoresActivos > 0 || escribiendo) {
                System.out.println(nombre + " espera para escribir...");
                puedeEscribir.await();
            }
            escritoresEsperando--;
            escribiendo = true;
            System.out.println(nombre + " empieza a escribir...");
        } finally {
            lock.unlock();
        }
    }

    // --- SALIR COMO ESCRITOR ---
    public void terminarEscribir(String nombre) {
        lock.lock();
        try {
            escribiendo = false;
            System.out.println(nombre + " terminó de escribir.");
            // Prioridad a los lectores si no hay escritores esperando
            if (escritoresEsperando > 0) {
                puedeEscribir.signal();
            } else {
                puedeLeer.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
