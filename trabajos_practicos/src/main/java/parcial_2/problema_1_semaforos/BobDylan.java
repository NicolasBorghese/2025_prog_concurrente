package parcial_2.problema_1_semaforos;

import java.util.Random;

public class BobDylan implements Runnable{

    //ATRIBUTOS
    Mesa mesa;

    public BobDylan(Mesa mesa){
        this.mesa = mesa;
    }

    public void run(){
        Random rng = new Random();
        int duracion = 0;

        while(true){
            int tipoCancion = rng.nextInt(0, 3);

            switch (tipoCancion){
                case 0:
                    duracion = 150;
                    break;
                case 1:
                    duracion = 180;
                    break;
                case 2:
                    duracion = 240;
                    break;
                case 3:
                    duracion = 300;
                    break;
            }

            String nombreCancion = "Un nombre de cancion";

            Cancion nuevaCancion = new Cancion(nombreCancion, duracion, tipoCancion);

            this.mesa.colocarCancion(nuevaCancion, "BobDylan");

            try{
                Thread.sleep(3000);
            }catch(Exception e){
                System.out.println("Error al dormir luego de colocar canción");
            }
        }

    }
}
