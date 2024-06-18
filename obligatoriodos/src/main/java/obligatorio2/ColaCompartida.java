package obligatorio2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ColaCompartida<T> {
    private Queue<T> cola;
    private int capacidad;
    private Semaphore semaforoProduccion;
    private Semaphore semaforoConsumo;
    private Semaphore mutex;

    public ColaCompartida(int capacidad) {
        this.cola = new LinkedList<>();
        this.capacidad = capacidad;
        this.semaforoProduccion = new Semaphore(capacidad);
        this.semaforoConsumo = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }

    public void put(T item) throws InterruptedException {
        semaforoProduccion.acquire();
        mutex.acquire();
        cola.add(item);
        mutex.release();
        semaforoConsumo.release();
    }

    public T take() throws InterruptedException {
        semaforoConsumo.acquire();
        mutex.acquire();
        T item = cola.poll();
        mutex.release();
        semaforoProduccion.release();
        return item;
    }
}
