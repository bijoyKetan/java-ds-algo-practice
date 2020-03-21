package misc_topics.concurrency;

/**
 * A sample class demonstrating how deadlock can occur and how it can be avoided
 * Solution: Ensure that both threads order the locks in the same order.
 */
public class Deadlock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

        Runnable t1 = () -> {
            synchronized (lock1) {
                System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock 1 and running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock 1 and lock 2 and running...");
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " release lock 2");
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " release lock 1 and exiting...");
        };

        //Code for deadlock
        Runnable t2 = () -> {
            synchronized (lock2) {
                System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock 2 and running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock 1 and lock 2 and running...");
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " release lock 1");
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " release lock 2 and exiting...");
        };

//        //Code for avoiding deadlock
//        Runnable t2 = () -> {
//            synchronized (lock1) {
//                System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock 1 and running...");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Thread " + Thread.currentThread().getName() + " waiting for lock 2...");
//                synchronized (lock2) {
//                    System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock 1 and lock 2 and running...");
//                }
//                System.out.println("Thread " + Thread.currentThread().getName() + " release lock 2");
//            }
//            System.out.println("Thread " + Thread.currentThread().getName() + " release lock 1 and exiting...");
//        };

        new Thread(t1).start();
        new Thread(t2).start();

    }
}

