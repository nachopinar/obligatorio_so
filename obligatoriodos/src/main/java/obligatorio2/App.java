package obligatorio2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;


public class App 
{
    public static void main(String[] args) {
        ColaCompartida<Integer> cola = new ColaCompartida<>(10);

        // Crear y lanzar el hilo del productor
        Thread productor = new Thread(new Productor(cola));
        productor.start();

        // Crear y lanzar el hilo del consumidor
        Thread consumidor = new Thread(new Consumidor(cola));
        consumidor.start();
    }
}
