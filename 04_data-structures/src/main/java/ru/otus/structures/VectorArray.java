package ru.otus.structures;

public class VectorArray<T> implements IArray<T> {

    public T[] array;
    int vector;
    int size = 0;

    public VectorArray(int vector) {
        this.vector = vector;
        array = (T[]) (new Object[vector]);
        this.size = 0;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    /**
     * N * (N/vector) ~ O(N^2)
     * @param item
     */
    @Override
    public void put(T item) {
        if (size() == array.length) {
            resize();
        }
        array[size()] = item;
        size++;
    }

    private void resize() {
        T[] newArray = (T[]) (new Object[size() + vector]);
        System.arraycopy(array, 0, newArray, 0 , size());
        array = newArray;
    }

    @Override
    public void put(T item, int index) {

    }

    @Override
    public int size() {
        return size;
    }
}
