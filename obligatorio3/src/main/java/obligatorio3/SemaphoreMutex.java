package obligatorio3;

public class SemaphoreMutex {
    private boolean signal = false;

    public synchronized void acquire() throws InterruptedException {
        while (signal) {
            wait();
        }
        signal = true;
    }

    public synchronized void release() {
        signal = false;
        notify();
    }
}
