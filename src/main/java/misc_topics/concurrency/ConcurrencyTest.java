package misc_topics.concurrency;

public class ConcurrencyTest {

    public static void main(String[] args) {
        //main thread
        System.out.println("Running thread is: " + Thread.currentThread().getName());

        //Create a runnable and start it using lambda function
        //Runnable is a functional interface
        Runnable runnable = () -> {
            System.out.println("Running thread is: " + Thread.currentThread().getName());
        };
        //Thread t1 = new Thread(runnable);
        //t1.start();
        new Thread(runnable).start();

        //Create a new thread of sample thread class and start it
        SampleThread sampleThread = new SampleThread();
        sampleThread.run();
    }
}
