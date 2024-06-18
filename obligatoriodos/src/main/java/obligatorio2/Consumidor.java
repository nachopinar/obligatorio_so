package obligatorio2;

public class Consumidor implements Runnable {
    private ColaCompartida<Integer> cola;

    public Consumidor(ColaCompartida<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer valor = cola.take();
                System.out.println("Consumido: " + valor);
                Thread.sleep(1500); // Simula el tiempo de consumo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
