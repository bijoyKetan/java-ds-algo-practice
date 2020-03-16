package misc_topics.concurrency;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer sharedBuffer = new Buffer(Arrays.asList(1, 2));
        ReentrantLock bufferLock = new ReentrantLock();
        Condition condition = bufferLock.newCondition();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer p1 = new MyProducer(ThreadColor.ANSI_CYAN, sharedBuffer, 2, bufferLock, condition);
        MyConsumer c1 = new MyConsumer(ThreadColor.ANSI_RED, sharedBuffer, bufferLock, condition);

        executorService.execute(p1);
        executorService.execute(c1);
    }
}

/**
 * Producer class that adds item to queue
 */
class MyProducer implements Runnable {

    private String color;
    private final Buffer buffer;
    int startingPoint;
    private final ReentrantLock bufferLock;
    private Condition condition;

    public MyProducer(String color, Buffer buffer, int startingPoint, ReentrantLock bufferLock, Condition condition) {
        this.color = color;
        this.buffer = buffer;
        this.startingPoint = startingPoint;
        this.bufferLock = bufferLock;
        this.condition = condition;
    }

    @Override
    public void run() {

        while (true) {
            bufferLock.lock();
            if (!buffer.isFull()) {
                try {
                    buffer.addItemToBuffer(startingPoint++);
                    System.out.println(color + "Producer " + Thread.currentThread().getName() + " added: " + startingPoint + "\n------------------------------\n");
//                    condition.await();
                    bufferLock.unlock();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Buffer full, producer can't add to buffer...");
//            condition.signalAll();
                try {
                    Thread.sleep(500);
                    bufferLock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * Consumer class that takes off items from the queue and processes item
 */

class MyConsumer implements Runnable {
    private String color;
    private Buffer buffer;
    private ReentrantLock bufferLock;
    private Condition condition;

    public MyConsumer(String color, Buffer buffer, ReentrantLock bufferLock, Condition condition) {
        this.color = color;
        this.buffer = buffer;
        this.bufferLock = bufferLock;
        this.condition = condition;

    }

    @Override
    public void run() {

        while (true) {
            bufferLock.lock();
            if (!buffer.isEmpty()) {
                try {
                    System.out.println(color + "Consumer " + Thread.currentThread().getName() + " consumed: " + buffer.removeItemFromBuffer() + "\n------------------------------\n");
//                    condition.await();
                    bufferLock.unlock();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Buffer empty, consumer cannot consume...");

//                condition.signalAll();
                try {
                    Thread.sleep(500);
                    bufferLock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}

/**
 * Buffer class that holds the items.
 * Producer adds items to buffer.
 * Consumer consumes items from buffer.
 */
class Buffer {
    private Queue<Integer> buffer;
    private final int max_size = 10;

    public Buffer(List<Integer> items) {
        if (items.size() > max_size) {
            throw new IllegalArgumentException("Max queue size is 10");
        }
        this.buffer = new LinkedList<>();
        for (Integer i : items) {
            buffer.offer(i);
        }
    }

    public boolean isEmpty() {
        return (buffer.size() == 0);
    }

    public boolean isFull() {
        return (buffer.size() == max_size);
    }

    public void addItemToBuffer(int a) {
        buffer.add(a);
    }

    public int removeItemFromBuffer() {
        return buffer.poll();
    }

    public List<Integer> getBufferValues() {
        List<Integer> bufferValuesToList = new ArrayList<>();
        bufferValuesToList.addAll(this.buffer);
        return bufferValuesToList;
    }

    @Override
    public String toString() {
        return "Buffer{" +
                "buffer=" + buffer +
                ", max_size=" + max_size +
                '}';
    }
}
