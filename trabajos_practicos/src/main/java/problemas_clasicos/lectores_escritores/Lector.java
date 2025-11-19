package problemas_clasicos.lectores_escritores;

class Lector implements Runnable {
    private final RecursoCompartido recurso;
    private final String nombre;

    public Lector(RecursoCompartido recurso, String nombre) {
        this.recurso = recurso;
        this.nombre = nombre;
    }

    public void run() {
        try {
            while (true) {
                recurso.empezarLeer(nombre);
                Thread.sleep((int)(Math.random() * 1000)); // simula tiempo de lectura
                recurso.terminarLeer(nombre);
                Thread.sleep((int)(Math.random() * 1500)); // tiempo entre lecturas
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
