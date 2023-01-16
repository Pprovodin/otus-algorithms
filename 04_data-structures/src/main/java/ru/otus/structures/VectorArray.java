package ru.otus.structures;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class VectorArray<T> implements IArray<T> {

    public T[] array;
    int vector;
    int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = (T[]) (new Object[vector]);
        this.size = 0;
    }

    public VectorArray(T[] array) {
        this.array = array;
        this.vector = 10;
        this.size = array.length;
    }

    public VectorArray(T[] array, int vector) {
        this.array = array;
        this.vector = vector;
        this.size = array.length;
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
        if (size == array.length) {
            resize();
        }
        array[size] = item;
        size++;
    }

    private void resize() {
        T[] newArray = (T[]) (new Object[size + vector]);
        System.arraycopy(array, 0, newArray, 0 , size);
        array = newArray;
    }

    @Override
    public void put(T item, int index) {
        if (size == array.length)
            array = Arrays.copyOf(array, size + vector);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        T oldValue = array[index];
        int newSize = size - 1;
        if (newSize > index)
            System.arraycopy(array, index + 1, array, index, newSize - index);
        array[newSize] = null;
        size--;
        return oldValue;
    }

    @Override
    public String toString() {
        if (array == null)
            return "null";

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorArray<?> that = (VectorArray<?>) o;
        return Arrays.equals(array, 0, size, that.array, 0, size);
    }

    @Override
    public int hashCode() {
        return  31 * Arrays.hashCode(array);
    }
}
