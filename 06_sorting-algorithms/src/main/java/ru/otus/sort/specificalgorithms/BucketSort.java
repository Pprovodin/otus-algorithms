package ru.otus.sort.specificalgorithms;

import ru.otus.sort.Sort;

import java.util.*;

public class BucketSort extends Sort {

    public BucketSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        final int numberOfBuckets = (int) Math.sqrt(array.length);
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        for(int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        int max = Arrays.stream(array).max().orElseThrow(() -> new RuntimeException("There is no max"));

        for (int element : array) {
            buckets.get(hash(element, max, numberOfBuckets)).add(element);
        }

        for(List<Integer> bucket  : buckets){
            Collections.sort(bucket);
        }

        int index = 0;
        for(List<Integer> bucket : buckets) {
            for (Integer element : bucket) {
                array[index++] = element;
            }
        }
    }

    private int hash(int i, int max, int numberOfBuckets) {
        return (int) ((double) i / max * (numberOfBuckets - 1));
    }
}
