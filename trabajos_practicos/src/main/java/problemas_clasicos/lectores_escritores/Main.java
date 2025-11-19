package problemas_clasicos.lectores_escritores;

public class Main {
    public static void main(String[] args) {
        RecursoCompartido recurso = new RecursoCompartido();

        // Creamos varios lectores y escritores
        Thread lector1 = new Thread(new Lector(recurso, "Lector-1"));
        Thread lector2 = new Thread(new Lector(recurso, "Lector-2"));
        Thread lector3 = new Thread(new Lector(recurso, "Lector-3"));
        Thread escritor1 = new Thread(new Escritor(recurso, "Escritor-1"));
        Thread escritor2 = new Thread(new Escritor(recurso, "Escritor-2"));

        lector1.start();
        lector2.start();
        lector3.start();
        escritor1.start();
        escritor2.start();
    }
}
