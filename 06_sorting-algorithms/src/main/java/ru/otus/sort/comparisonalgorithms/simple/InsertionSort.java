package ru.otus.sort.comparisonalgorithms.simple;

import ru.otus.sort.Sort;

public class InsertionSort extends Sort {

    public InsertionSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && more(j, j + 1); j--) {
                swap(j, j + 1);
            }
        }
    }
}
