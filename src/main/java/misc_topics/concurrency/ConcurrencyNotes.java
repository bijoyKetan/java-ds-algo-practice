package misc_topics.concurrency;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConcurrencyNotes {
    private static final Logger log = LoggerFactory.getLogger(ConcurrencyNotes.class);
    private final BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(1000);
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, taskQueue);

    public String timeTest() {
        final var time = LocalDateTime.now().toString();
        return String.format("The time now is %s", time);
    }

    @Test
    public void threadTest() {
        threadPoolExecutor.execute(() -> {
            System.out.println(timeTest());
        });
    }
}
