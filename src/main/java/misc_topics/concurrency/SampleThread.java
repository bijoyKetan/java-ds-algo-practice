package misc_topics.concurrency;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class SampleThread implements Runnable {

    private Map<String, Double> createList() {
        List<String> cityList = Arrays.asList("New York", "LA", "Seattle", "DC");
        List<Double> populationMillionList = Arrays.asList(8.623, 4.0, 0.725, 0.633);
        Map<String, Double> cityPopulation = new HashMap<>();
        IntStream.range(0, cityList.size())
                .forEach(i -> cityPopulation.put(cityList.get(i), populationMillionList.get(i)));
        return cityPopulation;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Sample class thread");
        System.out.println("Running thread is: " + Thread.currentThread().getName() + " -> Created list:  " +  createList());

    }

    @Test
    public void testRunner() {
        run();
    }
}
