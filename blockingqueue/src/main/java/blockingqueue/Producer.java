package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Clase Productor
public class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private int counter = 0;

    Producer(BlockingQueue<Integer> q) { 
        queue = q; 
    }

    public void run() {
        try {
            while (true) {
                queue.put(produce());
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            // Manejar la excepción
            ex.printStackTrace();
        }
    }

    Integer produce() {
        // Producir un número entero secuencial
        int producedValue = counter++;
        System.out.println("Producido: " + producedValue);
        return producedValue;
    }
}