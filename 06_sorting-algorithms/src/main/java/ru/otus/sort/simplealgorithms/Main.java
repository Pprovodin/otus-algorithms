package ru.otus.sort.simplealgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.otus.sort.Sort;

public class Main {
    public static void main(String[] args) {
//        List<Class<? extends Sort>> sortingAlgorithms =
//                new ArrayList<Class<? extends Sort>>(List.of(BubbleSort, Optimized));
        List<Integer> sizes = new ArrayList<>(List.of(100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000));

        for (Integer size : sizes) {
            int[] array = new Random().ints(0,10_000_000).limit(size).toArray();

            Sort bubbleSort = new BubbleSort(array);
            Sort insertionSort = new Ins
        }
    }
}
