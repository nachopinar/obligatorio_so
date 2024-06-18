package obligatorio2;

public class Productor implements Runnable {
    private ColaCompartida<Integer> cola;

    public Productor(ColaCompartida<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        int valor = 0;
        try {
            while (true) {
                Thread.sleep(1000); // Simula el tiempo de producción
                cola.put(valor);
                System.out.println("Producido: " + valor);
                valor++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


