package tp_2_prog_concurrente.ejercicio_6;

public class Corredor implements Runnable{

    //Atributos
    private String nombreCorredor;
    private int distanciaRecorrida;
    private Double velocidad;
    private int cantPasos;

    public String getNombreCorredor(){
        return this.nombreCorredor;
    }

    public int getDistanciaRecorrida(){
        return this.distanciaRecorrida;
    }

    public Double getVelocidad(){
        return this.velocidad;
    }

    public Corredor(String nombreCorredor){
        this.nombreCorredor = nombreCorredor;
        this.distanciaRecorrida = 0;
        this.cantPasos = 20;
    }

    public void run(){
            for (int i = 1; i <= cantPasos; i++){
                int cantDesplazamiento = (int) (Math.random() * 10) + 1;
                this.distanciaRecorrida = this.distanciaRecorrida + cantDesplazamiento;
                System.out.println("Paso: "+ i +" | Corredor: " + this.nombreCorredor + " avanza: " + cantDesplazamiento + " unidades.");
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            this.velocidad = (double) (distanciaRecorrida/cantPasos);
    }
}