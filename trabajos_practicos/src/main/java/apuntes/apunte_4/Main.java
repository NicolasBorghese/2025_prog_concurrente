package apuntes.apunte_4;

public class Main {
    public static void main(String[] args) {
        Rueda rueda = new Rueda();
        Plato plato = new Plato(3);

        for(int i=0; i < 7; i++ ){
            HamsterMonitor hamster = new HamsterMonitor(plato, rueda, "pepe"+i);
            Thread hilo = new Thread(hamster);
            hilo.start();
        }
    }

    public static class Rueda {

        public synchronized void rodar(String nombre){
            System.out.println (nombre + " empieza a rodar" );
            try {
                Thread.sleep((long) Math.random()*1500);
            } catch (InterruptedException ex){
                System.out.println("Error");
            }
        }
    }
    public static class Plato {
        private int cantidad;
        private int comiendo;
        public Plato(int maximo){
            cantidad = maximo;
            comiendo = 0;
        }
        public synchronized void empezarAComer(String nombre){
            try {
                while (comiendo >= 3){
                    System.out.println(nombre + " debe esperar para comer");
                    this.wait();
                }
            } catch (InterruptedException ex){
                System.out.println("Error");
            }
            System.out.println( nombre + " empieza a comer");
            comiendo ++;
        }
        public synchronized void terminarDeComer(String nombre){
            System.out.println( nombre + " termino de comer");
            comiendo --;
            this.notify();
        }

        public synchronized void comer(String nombre){
            try {
                while (comiendo >= cantidad){
                    System.out.println( nombre + " debe esperar para comer");
                    this.wait();
                }
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
            System.out.println( nombre + " empieza a comer");
            comiendo++;
            try {
                Thread.sleep((long) Math.random()*1500);
            } catch (InterruptedException ex){
                System.out.println("Error");
            }
            System.out.println( nombre + " termino de comer");
            comiendo--;
            this.notify();
        }
    }

    public static class HamsterMonitor2 implements Runnable {
        private Plato comida;
        private Rueda ejercicio;
        private String miNombre;

        public HamsterMonitor2(Plato laComida, Rueda elEjercicio, String nombre){
            comida = laComida;
            ejercicio = elEjercicio;
            miNombre = nombre;
        }

        public void run(){

                comida.empezarAComer(miNombre);
                try {
                    Thread.sleep((long) Math.random()*1500);
                } catch (InterruptedException ex){
                    System.out.println("Error");
                }
                comida.terminarDeComer(miNombre);
                ejercicio.rodar(miNombre);

        }
    }

    public static class HamsterMonitor implements Runnable {
        private Plato comida;
        private Rueda ejercicio;
        private String miNombre;

        public HamsterMonitor(Plato laComida, Rueda elEjercicio, String nombre){
            comida = laComida;
            ejercicio = elEjercicio;
            miNombre = nombre;
        }

        public void run(){

            comida.comer(miNombre);
            ejercicio.rodar(miNombre);
            try {
                Thread.sleep((long) Math.random()*3500);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }

    }
}
