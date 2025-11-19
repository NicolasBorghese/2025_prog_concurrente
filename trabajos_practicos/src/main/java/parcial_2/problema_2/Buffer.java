package parcial_2.problema_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * RESOLUCIÓN CON LOCKS
 */
public class Buffer {

    private Queue<Integer> cola1 = new LinkedList<Integer>();
    private Queue<Integer> cola2 = new LinkedList<Integer>();
    boolean cola1Insertar = true;
    boolean sinElementos = true;
    private Lock lockInsertar = new ReentrantLock();
    private Lock lockExtraer = new ReentrantLock();
    private Condition puedeExtraer = lockExtraer.newCondition();

    public Buffer(){
        //Por ahora nada
    }

    public void insertarElemento(int elemento, String nombreInsertor){
        lockInsertar.lock();

        if(cola1Insertar){
            cola1.add(elemento);
            System.out.println("Elemento insertado: " + elemento + " por " + nombreInsertor
                    + " en cola 1");
        } else {
            cola2.add(elemento);
            System.out.println("Elemento insertado: " + elemento + " por " + nombreInsertor
                    + " en cola 2");
        }
        sinElementos = false;
        puedeExtraer.signal();
        lockInsertar.unlock();
    }

    public int extraerElemento(String nombreExtractor){
        lockExtraer.lock();
        int elemento = 0;
        boolean pudoExtraer = false;

        while(sinElementos){
            try{
                System.out.println("Intenta extraer sin elementos: "+nombreExtractor);
                puedeExtraer.await();
            } catch (Exception ex) {
                System.out.println("Error al extraer");
            }
        }

        if (!cola1Insertar && !cola1.isEmpty()){
            elemento = cola1.poll();
            System.out.println(nombreExtractor + " Extrae el elemento: " + elemento + " de cola 1");
        } else if (!cola1Insertar && !cola2.isEmpty()){
            elemento = cola2.poll();
            System.out.println(nombreExtractor + " Extrae el elemento: " + elemento + " de cola 2");
        } else if (!cola1Insertar && !cola1.isEmpty()){
            cola1Insertar = true;
            elemento = cola1.poll();
            System.out.println(nombreExtractor + " Extrae el elemento: " + elemento + " en cola 1");
        } else if (cola1Insertar && !cola2.isEmpty()){
            cola1Insertar = false;
            elemento = cola2.poll();
            System.out.println(nombreExtractor + " Extrae el elemento: " + elemento + " en cola 1");
        }

        if(cola1.isEmpty() && cola2.isEmpty()){
            sinElementos = true;
        }

        lockExtraer.unlock();
        return elemento;
    }
}
