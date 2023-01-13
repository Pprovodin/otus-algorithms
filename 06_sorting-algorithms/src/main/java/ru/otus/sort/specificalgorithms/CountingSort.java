package ru.otus.sort.specificalgorithms;

import ru.otus.sort.Sort;

import java.util.Arrays;
import java.util.OptionalInt;

public class CountingSort extends Sort {

    public CountingSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        OptionalInt max = Arrays.stream(array).max();
        int[] occurrenceArray = countElements(array, max.orElseThrow(() -> new RuntimeException("There is no max")));

        int[] sorted = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int current = array[i];
            sorted[occurrenceArray[current] - 1] = current;
            occurrenceArray[current] -= 1;
        }
        System.arraycopy(sorted, 0, array, 0, array.length);
    }

    private int[] countElements(int[] input, int k) {
        int[] occurrenceArray = new int[k + 1];
        Arrays.fill(occurrenceArray, 0);

        for (int i : input) {
            occurrenceArray[i] += 1;
        }

        for (int i = 1; i < occurrenceArray.length; i++) {
            occurrenceArray[i] += occurrenceArray[i - 1];
        }

        return occurrenceArray;
    }
}
