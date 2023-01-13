package ru.otus.sort;

public abstract class Sort {
    protected final int[] array;

    public Sort(int[] array) {
        this.array = array;
    }

    public abstract void sort();

    protected void swap(int i, int j) {
        int k = array[i];
        array[i] = array[j];
        array[j] = k;
    }

    protected boolean more(int x, int y) {
        return array[x] > array[y];
    }
}
