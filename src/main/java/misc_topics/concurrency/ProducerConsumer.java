package misc_topics.concurrency;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer sharedBuffer = new Buffer(Arrays.asList(1, 2));
        ReentrantLock bufferLock = new ReentrantLock();

        MyProducer p1 = new MyProducer(ThreadColor.ANSI_CYAN, sharedBuffer, bufferLock);
//        MyProducer p2 = new MyProducer(ThreadColor.ANSI_CYAN, sharedBuffer, bufferLock);
        MyConsumer c1 = new MyConsumer(ThreadColor.ANSI_RED, sharedBuffer, bufferLock);
//        MyConsumer c2 = new MyConsumer(ThreadColor.ANSI_RED, sharedBuffer, bufferLock);


        new Thread(p1).start();
//        new Thread(p2).start();
        new Thread(c1).start();
//        new Thread(c2).start();
    }
}

/**
 * Producer class that adds item to queue
 */
class MyProducer implements Runnable {

    private String color;
    private final Buffer buffer;
    int startingPoint ;
    private final ReentrantLock bufferLock;

    public MyProducer(String color, Buffer buffer, ReentrantLock bufferLock) {
        this.color = color;
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        startingPoint = 2;
        bufferLock.lock();
        try {
            while (!buffer.isFull()) {
                try {
                    buffer.addItemToBuffer(startingPoint++);
                    System.out.println(color + "Producer " + Thread.currentThread().getName() + " added: " + startingPoint + "\n------------------------------\n");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            System.out.println("The buffer is full so producer cannot add....");
            bufferLock.unlock();
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

    public MyConsumer(String color, Buffer buffer, ReentrantLock bufferLock) {
        this.color = color;
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        bufferLock.lock();
        try {
            while (!buffer.isEmpty()) {
                try {
                    System.out.println(color + "Consumer " + Thread.currentThread().getName() + " consumed: " + buffer.removeItemFromBuffer() + "\n------------------------------\n");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println("The buffer is empty, so consumer cannot consume....");
            bufferLock.unlock();
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

    public void addItemToBuffer(int a){
        buffer.add(a);
    }

    public int removeItemFromBuffer(){
        return buffer.poll();
    }

    public List<Integer> getBufferValues(){
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
