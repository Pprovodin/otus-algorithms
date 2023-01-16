package ru.otus.structures;

import lombok.EqualsAndHashCode;

import java.util.Arrays;

@EqualsAndHashCode
@SuppressWarnings("unchecked")
public class SingleArray<T> implements IArray<T> {

    private T[] array;
    private int size;

    public SingleArray() {
        array = (T[]) (new Object[0]);
        size = 0;
    }

    public SingleArray(T[] array) {
        this.array = array;
        this.size = array.length;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    /**
     * O(N^2)
     * @param item
     */
    @Override
    public void put(T item) {
        resize();
        array[size - 1] = item;
    }

    private void resize() {
        T[] newArray = (T[]) (new Object[size + 1]);
        System.arraycopy(array, 0, newArray, 0 , size);
        array = newArray;
        size++;
    }

    @Override
    public void put(T item, int index) {
        T[] newArray = (T[]) (new Object[size + 1]);
        System.arraycopy(array, 0, newArray, 0 , index);
        newArray[index] = item;
        System.arraycopy(array, index, newArray, index + 1, size - index);
        array = newArray;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        T oldValue = array[index];
        T[] newArray = (T[]) (new Object[size - 1]);

        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[k++] = array[i];
        }
        array = newArray;
        size--;
        return oldValue;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
