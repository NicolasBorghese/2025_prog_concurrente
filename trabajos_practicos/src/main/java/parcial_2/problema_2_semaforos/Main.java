package parcial_2.problema_2_semaforos;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        Extractor extractor1 = new Extractor(buffer, "Pepe");
        Extractor extractor2 = new Extractor(buffer, "Pepo");

        Insertor insertor1 = new Insertor(buffer, 10, "Jose");
        Insertor insertor2 = new Insertor(buffer, 20, "Marcos");
        Insertor insertor3 = new Insertor(buffer, 30, "Jesus");
        Insertor insertor4 = new Insertor(buffer, 40, "Maria");
        Insertor insertor5 = new Insertor(buffer, 50, "Pedro");
        Insertor insertor6 = new Insertor(buffer, 60, "Martin");

        Thread t1 = new Thread(extractor1);
        Thread t2 = new Thread(extractor2);
        Thread t3 = new Thread(insertor1);
        Thread t4 = new Thread(insertor2);
        Thread t5 = new Thread(insertor3);
        Thread t6 = new Thread(insertor4);
        Thread t7 = new Thread(insertor5);
        Thread t8 = new Thread(insertor6);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

    }
}
