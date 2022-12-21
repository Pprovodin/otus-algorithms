package ru.otus.sort;

public class BubbleSort {

    int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j+1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int i, int j) {
        int k = array[i];
        array[i] = array[j];
        array[j] = k;
    }
}
