package tp_3_sincronizacion.apunte_2;

/*public class TestSalaConcierto {

    public static void main(String[] args) {

    }

}

class SalaDeConcierto{
    boolean[] asientosLibresyOcupados;
    //TRUE SIGNIFICA QUE ESTÁ LIBRE

    public SalaDeConcierto(int tamanioSala) {
        asientosLibresyOcupados = new boolean[tamanioSala];
        this.iniciarAsientos();
    }

    private void iniciarAsientos() {
        for (int i = 0; i < asientosLibresyOcupados.length; i++) {
            asientosLibresyOcupados[i] = true;
        }
    }

    public boolean hayAsientosLibres(){
        int tamanioSala = asientosLibresyOcupados.length;
        int numeroAsiento = 0;
        boolean hayAsientosLibres = false;

        while(numeroAsiento < tamanioSala && !hayAsientosLibres){
            if(asientosLibresyOcupados[numeroAsiento]){
                hayAsientosLibres = true;
            } else {
                numeroAsiento++;
            }
        }
        return hayAsientosLibres;
    }

    public synchronized boolean verificarAsientoLibre(int numeroAsiento) {
        return asientosLibresyOcupados[numeroAsiento];
    }

    public synchronized void ocuparAsiento(int numeroAsiento){
        asientosLibresyOcupados[numeroAsiento] = false;
    }
}

class EmpleadoTerminal implements Runnable(){

    public void run(){

    }


}*/
