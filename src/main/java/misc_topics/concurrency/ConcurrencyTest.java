package misc_topics.concurrency;

public class ConcurrencyTest {

    public static void main(String[] args) {
        System.out.println("Main method thread name 1 is: " + Thread.currentThread().getName());

        Runnable runnable2 = () -> {
            Thread.currentThread().setName("Runnable Thread");
            System.out.println("Runnable thread name is : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
                System.out.println("Thread: " + Thread.currentThread().getName() + " woke up and started again...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable2).start();

        Thread t3 = new Thread(()-> {
            System.out.println("Thread: " + Thread.currentThread().getName() );
        });
        t3.start();

        System.out.println("Main method thread name 2 is: " + Thread.currentThread().getName());
    }


}
