package ru.otus.sort.specificalgorithms;

import ru.otus.Stopwatch;
import ru.otus.sort.Sort;
import ru.otus.sort.specificalgorithms.BucketSort;
import ru.otus.sort.specificalgorithms.CountingSort;
import ru.otus.sort.specificalgorithms.RadixSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SpecificAlgorithms {
    public static void main(String[] args) throws Exception {
        List<Class<? extends Sort>> sortingAlgorithms =
                new ArrayList<>(List.of(BucketSort.class,
                        CountingSort.class,
                        RadixSort.class));
        List<Integer> sizes = new ArrayList<>(List.of(100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000));

        Stopwatch stopwatch = new Stopwatch();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Integer size : sizes) {
            int[] array = new Random().ints(0, size).limit(size).toArray();
            int[] arrayForTest = new int[array.length];
            for (Class<? extends Sort> clazz : sortingAlgorithms) {
                System.arraycopy(array, 0, arrayForTest, 0, array.length);
                Sort sorter = clazz.getDeclaredConstructor(int[].class).newInstance(arrayForTest);
                Runnable task = sorter::sort;
                stopwatch.start();
                Future<?> future = executor.submit(task);
                try {
                    future.get(60, TimeUnit.SECONDS);
                    System.out.println("size = " + size + "; time = " + stopwatch.getElapsedTimeInMillis() +
                            "; algorithm - " + sorter.getClass().getSimpleName());
                } catch (TimeoutException ex) {
                    System.out.println("size = " + size + "; timeout (" +
                            stopwatch.getElapsedTimeInSeconds() + "seconds); algorithm - " +
                            sorter.getClass().getSimpleName());
                } finally {
                    stopwatch.stop();
                    future.cancel(true); // may or may not desire this
                }
            }
        }
        executor.shutdownNow();
    }
}
