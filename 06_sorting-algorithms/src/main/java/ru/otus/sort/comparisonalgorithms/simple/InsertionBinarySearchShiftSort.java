package ru.otus.sort.comparisonalgorithms.simple;

import ru.otus.sort.Sort;

public class InsertionBinarySearchShiftSort extends Sort {

    public InsertionBinarySearchShiftSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int j;
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            int p = binarySearch(k, 0, i - 1);
            for (j = i - 1; j >= p; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = k;
        }
    }

    private int binarySearch(int key, int low, int high) {
        if (high <= low) {
            if (key > array[low])
                return low + 1;
            else
                return low;
        }

        int mid = (low + high) / 2;
        //if (key == A[mid]) // non stable
        //    return mid + 1;
        if (key > array[mid])
            return binarySearch(key, mid + 1, high);
        else
            return binarySearch(key, low, mid - 1);
    }
}
