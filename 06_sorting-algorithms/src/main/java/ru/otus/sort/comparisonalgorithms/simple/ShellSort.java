package ru.otus.sort.comparisonalgorithms.simple;

import ru.otus.sort.Sort;

public class ShellSort extends Sort {

    public ShellSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j >= gap && more(j - gap, j); j -= gap) {
                    swap(j, j - gap);
                }
            }
        }
    }
}
