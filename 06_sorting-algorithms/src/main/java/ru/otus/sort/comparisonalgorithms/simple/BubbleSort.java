package ru.otus.sort.comparisonalgorithms.simple;

import ru.otus.sort.Sort;

public class BubbleSort extends Sort {

    public BubbleSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (more(j, j + 1)) {
                    swap(j, j + 1);
                }
            }
        }
    }
}
