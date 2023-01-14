package ru.otus;

import ru.otus.barn.BarnSolution;
import ru.otus.barn.impl.BarnBestSolution;
import ru.otus.barn.impl.BarnBetterSolution;
import ru.otus.barn.impl.BarnBetterSolutionOptimized;
import ru.otus.barn.impl.BarnEasySolution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class Main {
    private static final Map<Class<? extends BarnSolution>, Boolean> barnAlgorithms = new LinkedHashMap<>() {{
       put(BarnEasySolution.class, Boolean.TRUE);
       put(BarnBetterSolution.class, Boolean.TRUE);
       put(BarnBetterSolutionOptimized.class, Boolean.TRUE);
       put(BarnBestSolution.class, Boolean.TRUE);
    }};
    private static final int[] Ns = {1000, 2000, 5000, 10000, 20000, 30000};
    private static final int[] Fs = {10, 20, 50, 100};

    public static void main( String[] args ) throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int size : Ns) {
            for (int density : Fs) {
                for (Class<? extends BarnSolution> clazz : barnAlgorithms.keySet()) {
                    if (barnAlgorithms.get(clazz)) {
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
                            barnAlgorithms.put(clazz, Boolean.FALSE);
                            System.out.println("Size: " + size + ":" + density +
                                    "\ttimeout (" + stopwatch.getElapsedTimeInSeconds() + " seconds)" +
                                    "\tAlgorithm: " + barnSolution.getClass().getSimpleName());
                        } finally {
                            stopwatch.stop();
                            future.cancel(true); // may or may not desire this
                        }
                    } else {
                        System.out.println("Size: " + size + ":" + density +
                                "\ttimeout (60 seconds)" +
                                "\tAlgorithm: " + clazz.getSimpleName());
                    }
                }
            }
        }
    }
}
