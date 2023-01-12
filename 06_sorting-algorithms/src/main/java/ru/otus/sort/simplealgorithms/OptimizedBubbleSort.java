package ru.otus.sort.simplealgorithms;

import ru.otus.sort.Sort;

public class OptimizedBubbleSort extends Sort {

    public OptimizedBubbleSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = 1; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i; j++) {
                if (more(j, j + 1)) {
                    flag = true;
                    swap(j, j + 1);
                }
            }
            if (!flag) return;
        }
    }
}
