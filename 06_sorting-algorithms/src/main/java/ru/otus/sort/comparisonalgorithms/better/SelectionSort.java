package ru.otus.sort.comparisonalgorithms.better;

import ru.otus.sort.Sort;

public class SelectionSort extends Sort {

    public SelectionSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int max = findMax(array.length);
        for (int h = array.length - 1; h > 0; h--) {
            swap(max, h);
            max = findMax(h);
        }
    }

    private int findMax(int size) {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }
}
