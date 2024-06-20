package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> q) { 
        queue = q; 
    }

    public void run() {
        try {
            while (true) {
                consume(queue.take());
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            // Manejar la excepción
            ex.printStackTrace();
        }
    }

    void consume(Integer x) {
        // Consumir el número entero
        System.out.println("Consumido: " + x);
    }
}
