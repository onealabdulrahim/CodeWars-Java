package ThreadedCounting;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedCounting {

    private static final int NUM_THREADS = 3;

    public static void countInThreads(Counter counter) {
        ExecutorService[] singleThreadExecutors = new ExecutorService[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            singleThreadExecutors[i] = Executors.newSingleThreadExecutor();
        }

        try {
            for (int i = 0; i < 100; i++) {
                final int count = i + 1;
                singleThreadExecutors[i % NUM_THREADS].submit(() -> counter.count(count)).get();
            }
        } catch (InterruptedException | ExecutionException e) {System.err.printf(e.getMessage());}

        for (int i = 0; i < NUM_THREADS; i++) {
            singleThreadExecutors[i].shutdown();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        countInThreads(counter);
        System.out.println(counter.values);
    }
}
