package parcial_2.problema_1_semaforos;

public class Main {

    public static void main(String[] args) {

        Mesa mesa = new Mesa();
        Album album = new Album();

        BobDylan bob = new BobDylan(mesa);
        Manager manager = new Manager("Mario", album);

        Productor[] productores = new Productor[4];
        Thread[] hilosProd = new Thread[4];

        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Productor(mesa, album, ("Prod"+i), i);
            hilosProd[i] = new Thread(productores[i]);
            hilosProd[i].start();
        }

        Thread hilo1 = new Thread(bob);
        Thread hilo2 = new Thread(manager);
        hilo1.start();
        hilo2.start();
    }
}
