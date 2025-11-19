package problemas_clasicos.lectores_escritores;

class Escritor implements Runnable {
    private final RecursoCompartido recurso;
    private final String nombre;

    public Escritor(RecursoCompartido recurso, String nombre) {
        this.recurso = recurso;
        this.nombre = nombre;
    }

    public void run() {
        try {
            while (true) {
                recurso.empezarEscribir(nombre);
                Thread.sleep((int)(Math.random() * 1500)); // simula tiempo de escritura
                recurso.terminarEscribir(nombre);
                Thread.sleep((int)(Math.random() * 2000)); // tiempo entre escrituras
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
