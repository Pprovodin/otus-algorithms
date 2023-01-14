package ru.otus;

import ru.otus.barn.BarnSolution;
import ru.otus.barn.impl.BarnBestSolution;
import ru.otus.barn.impl.BarnBetterSolution;
import ru.otus.barn.impl.BarnBetterSolutionOptimized;
import ru.otus.barn.impl.BarnEasySolution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class Main {
    private static final List<Class<? extends BarnSolution>> barnAlgorithms = new ArrayList<>(List.of(
            BarnEasySolution.class,
                    BarnBetterSolution.class,
                    BarnBetterSolutionOptimized.class,
                    BarnBestSolution.class)
    );
    private static final int[] Ns = {1000, 2000, 5000, 10000, 20000, 30000};
    private static final int[] Fs = {10, 20, 50, 100};

    public static void main( String[] args ) throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int size : Ns) {
            for (int density : Fs) {
                for (Class<? extends BarnSolution> clazz : barnAlgorithms){
                    boolean[][] map = BarnSolution.generateMap(size, density, 123456);
                    BarnSolution barnSolution = clazz.getDeclaredConstructor(boolean[][].class).newInstance((Object) map);
                    Runnable task = barnSolution::solve;
                    stopwatch.start();
                    Future<?> future = executor.submit(task);
                    try {
                        future.get(60, TimeUnit.SECONDS);
                        System.out.println("Size: " + size + ":" + density +
                                "\tTime: " + stopwatch.getElapsedTimeInMillis() + " ms" +
                                "\tAlgorithm: " + barnSolution.getClass().getSimpleName());
                    } catch (TimeoutException ex) {
                        System.out.println("Size: " + size + ":" + density +
                                "\ttimeout (" + stopwatch.getElapsedTimeInSeconds() + "seconds)" +
                                "\tAlgorithm: " + barnSolution.getClass().getSimpleName());
                    } finally {
                        stopwatch.stop();
                        future.cancel(true); // may or may not desire this
                    }
                }
            }
        }
    }
}
