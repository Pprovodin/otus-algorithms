package ru.otus.sort.comparisonalgorithms.better;

import ru.otus.sort.Sort;

public class HeapSort extends Sort {

    public HeapSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int h = array.length / 2 - 1; h >= 0; h--) {
            heapify(h, array.length);
        }

        for (int h = array.length - 1; h > 0; h--) {
            swap(0, h);
            heapify(0, h);
        }
    }

    private void heapify(int root, int size) {
        //   X - index of max (root, L, R)
        //  / \
        // L   R
        // .....

        int X = root;
        int L = 2 * X + 1;
        int R = 2 * X + 2;

        if (L < size && array[L] > array[X]) {
            X = L;
        }
        if (R < size && array[R] > array[X]) {
            X = R;
        }

        if (X == root) {
            return;
        }
        swap(root, X);
        heapify(X, size);
    }
}
