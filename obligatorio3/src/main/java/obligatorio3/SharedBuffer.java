package obligatorio3;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;
    private final SemaphoreMutex mutex = new SemaphoreMutex();
    private final Object notFull = new Object();
    private final Object notEmpty = new Object();

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public void produce(int item) throws InterruptedException {
        synchronized (notFull) {
            while (buffer.size() == capacity) {
                notFull.wait();
            }
        }
        
        mutex.acquire();
        try {
            buffer.add(item);
            System.out.println("Produced: " + item);
        } finally {
            mutex.release();
        }

        synchronized (notEmpty) {
            notEmpty.notify();
        }
    }

    public int consume() throws InterruptedException {
        int item;

        synchronized (notEmpty) {
            while (buffer.isEmpty()) {
                notEmpty.wait();
            }
        }

        mutex.acquire();
        try {
            item = buffer.remove();
            System.out.println("Consumed: " + item);
        } finally {
            mutex.release();
        }

        synchronized (notFull) {
            notFull.notify();
        }

        return item;
    }
}
