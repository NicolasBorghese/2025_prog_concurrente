package parcial_2.problema_2;

public class Main {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Insertor insertor1 = new Insertor(buffer, 10, "Marcos");
        Insertor insertor2 = new Insertor(buffer, 20, "Jose");
        Insertor insertor3 = new Insertor(buffer, 30, "Ana");

        Extractor extractor1 = new Extractor(buffer, "Pepo");
        Extractor extractor2 = new Extractor(buffer, "Pipo");

        Thread hilo1 = new Thread(insertor1);
        Thread hilo2 = new Thread(insertor2);
        Thread hilo3 = new Thread(insertor3);
        Thread hilo4 = new Thread(extractor1);
        Thread hilo5 = new Thread(extractor2);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}
