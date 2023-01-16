package ru.otus;

import ru.otus.structures.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompareAlgorithms {
    public static void main(String[] args) throws Exception {
        IArray<Integer> singleArray = new SingleArray<>();
        IArray<Integer> vectorArray = new VectorArray<>(100);
        IArray<Integer> factorArray = new FactorArray<>();
        IArray<Integer> javaArray = new FactorJavaArray<>();
        IArray<Integer> matrixArray = new MatrixArray<>(100);

        List<IArray<Integer>> structureAlgorithms = new ArrayList<>(List.of(singleArray, vectorArray, factorArray, javaArray, matrixArray));
        List<Integer> sizes = new ArrayList<>(List.of(100, 1_000, 10_000, 100_000, 1_000_000));

        Stopwatch stopwatch = new Stopwatch();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Integer size : sizes) {
            for (IArray<Integer> array : structureAlgorithms) {
                Runnable task = () -> testPut(array, size);
                stopwatch.start();
                Future<?> future = executor.submit(task);
                try {
                    future.get(60, TimeUnit.SECONDS);
                    System.out.println("size = " + size + "; time = " + stopwatch.getElapsedTimeInMillis() +
                            "; algorithm - " + array.getClass().getSimpleName());
                } catch (TimeoutException ex) {
                    System.out.println("size = " + size + "; timeout (" +
                            stopwatch.getElapsedTimeInSeconds() + "seconds); algorithm - " +
                            array.getClass().getSimpleName());
                } finally {
                    stopwatch.stop();
                    future.cancel(true); // may or may not desire this
                }
            }
        }
        executor.shutdownNow();
    }

    private static void testPut(IArray<Integer> array, int total) {
        for (int j = 0; j < total; j++) {
            array.put(total/2, j);
        }
    }
}
