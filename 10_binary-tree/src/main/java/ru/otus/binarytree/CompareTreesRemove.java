package ru.otus.binarytree;

import ru.otus.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CompareTreesRemove {
    public static void main(String[] args) throws Exception {
        BinaryTree<Integer> binarySearchTree = new BinarySearchTree<>();
        BinaryTree<Integer> avlTree = new AvlTree<>();

        List<BinaryTree<Integer>> trees = new ArrayList<>(List.of(
                avlTree,
                binarySearchTree
        ));
        List<Integer> sizes = new ArrayList<>(List.of(100, 1_000, 10_000, 100_000, 1000000, 10000000));

        Stopwatch stopwatch = new Stopwatch();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Integer size : sizes) {
            for (BinaryTree<Integer> tree : trees) {
//                IntStream.range(0, size).forEach(tree::insert);
                new Random().ints(size, 1, size).forEach(tree::insert);
                Runnable task = () -> testRemove(tree, size);
                stopwatch.start();
                Future<?> future = executor.submit(task);
                try {
                    future.get(60, TimeUnit.SECONDS);
                    System.out.println("size = " + size + ";\ttime = " + stopwatch.getElapsedTimeInMillis() +
                            ";\talgorithm - " + tree.getClass().getSimpleName() + ";\theight - " + tree.getHeight());
                } catch (TimeoutException ex) {
                    System.out.println("size = " + size + ";\ttimeout (" +
                            stopwatch.getElapsedTimeInSeconds() + "seconds);\talgorithm - " +
                            tree.getClass().getSimpleName() + ";\theight - " + tree.getHeight());
                } finally {
                    stopwatch.stop();
                    future.cancel(true); // may or may not desire this
                    tree.clear();
                }
            }
        }
        executor.shutdownNow();
    }

    private static void testRemove(BinaryTree<Integer> tree, int total) {
        new Random().ints(total, 1, total).forEach(tree::insert);
        IntStream.range(0, total).filter(n -> n % 2 == 0).forEach(tree::remove);
    }
}
