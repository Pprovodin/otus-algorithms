package ru.otus.sort.simplealgorithms;

import ru.otus.sort.Sort;

public class InsertionShiftSort extends Sort {

    public InsertionShiftSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int j;
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            for (j = i - 1; j >= 0 && moreK(j, k); j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = k;
        }
    }

    private boolean moreK(int x, int k) {
        return array[x] > k;
    }
}
