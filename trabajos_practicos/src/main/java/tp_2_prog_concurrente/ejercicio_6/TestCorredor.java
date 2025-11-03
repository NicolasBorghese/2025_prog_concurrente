package tp_2_prog_concurrente.ejercicio_6;

public class TestCorredor {

    public static void main(String[] args) {

        int cantCorredores = 5;

        Corredor[] corredor = new Corredor[cantCorredores];
        corredor[0] = new Corredor("Colapinto");
        corredor[1] = new Corredor("Michael Jordan");
        corredor[2] = new Corredor("Usain Bolt");
        corredor[3] = new Corredor("Turbo");
        corredor[4] = new Corredor("Speedy Gonzales");

        Thread[] hilo = new Thread[cantCorredores];

        for(int i = 0; i < cantCorredores; i++){
            hilo[i] = new Thread(corredor[i]);
        }

        for(int i = 0; i < cantCorredores; i++){
            hilo[i].start();
        }

        try{
            Thread.sleep(3000);
            ordenamientoBurbuja(corredor);
            System.out.println("\uD83C\uDFC1 1er puesto: "+corredor[0].getNombreCorredor()+
                    " con "+corredor[0].getDistanciaRecorrida()+" unidades de distancia recorridas.");
            System.out.println("\uD83C\uDFC1 2do puesto: "+corredor[1].getNombreCorredor()+
                    " con "+corredor[1].getDistanciaRecorrida()+" unidades de distancia recorridas.");
            System.out.println("\uD83C\uDFC1 3er puesto: "+corredor[2].getNombreCorredor()+
                    " con "+corredor[2].getDistanciaRecorrida()+" unidades de distancia recorridas.");
            System.out.println("\uD83C\uDFC1 4to puesto: "+corredor[3].getNombreCorredor()+
                    " con "+corredor[3].getDistanciaRecorrida()+" unidades de distancia recorridas.");
            System.out.println("\uD83C\uDFC1 5to puesto: "+corredor[4].getNombreCorredor()+
                    " con "+corredor[4].getDistanciaRecorrida()+" unidades de distancia recorridas.");
        }catch(InterruptedException e){

        }
    }

    public static void ordenamientoBurbuja(Corredor[] arr) {
        int n = arr.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;

            // Recorre el arreglo comparando elementos adyacentes
            for (int j = 0; j < n - 1 - i; j++) {
                // Si el elemento actual es mayor que el siguiente, se intercambian
                if (arr[j].getDistanciaRecorrida() < arr[j + 1].getDistanciaRecorrida()) {
                    Corredor temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambio = true;
                }
            }

            // Si en esta pasada no hubo intercambios, el arreglo ya está ordenado
            if (!intercambio) {
                break;
            }
        }
    }
}
