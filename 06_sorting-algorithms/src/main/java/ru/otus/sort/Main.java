package ru.otus.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import ru.otus.Stopwatch;
import ru.otus.sort.bestalgorithms.MergeSort;
import ru.otus.sort.bestalgorithms.QuickSort;
import ru.otus.sort.seriousalgorithms.HeapSort;
import ru.otus.sort.seriousalgorithms.SelectionSort;
import ru.otus.sort.simplealgorithms.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Class<? extends Sort>> sortingAlgorithms =
                new ArrayList<>(List.of(BubbleSort.class,
                        OptimizedBubbleSort.class,
                        InsertionSort.class,
                        InsertionShiftSort.class,
                        InsertionBinarySearchShiftSort.class,
                        ShellSort.class,
                        SelectionSort.class,
                        HeapSort.class,
                        MergeSort.class,
                        QuickSort.class));
        List<Integer> sizes = new ArrayList<>(List.of(100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000));

        Stopwatch stopwatch = new Stopwatch();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Integer size : sizes) {
            int[] array = new Random().ints(0, size).limit(size).toArray();
            for (Class<? extends Sort> clazz : sortingAlgorithms) {
                Sort sorter = clazz.getDeclaredConstructor(int[].class).newInstance(array);
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
