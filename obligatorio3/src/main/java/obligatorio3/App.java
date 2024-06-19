package obligatorio3;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Tamaño del buffer

        Thread producer1 = new Thread(new Producer(buffer));
        Thread producer2 = new Thread(new Producer(buffer));
        Thread consumer1 = new Thread(new Consumer(buffer));
        Thread consumer2 = new Thread(new Consumer(buffer));

        producer1.start();
        //producer2.start();
        consumer1.start();
        // consumer2.start();
    }
}
