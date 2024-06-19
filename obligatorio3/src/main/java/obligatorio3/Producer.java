package obligatorio3;

public class Producer implements Runnable {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int item = 0;
        while (true) {
            try {
                buffer.produce(item++);
                Thread.sleep(1000); // Simula tiempo de producción
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

