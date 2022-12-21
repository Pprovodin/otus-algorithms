package ru.otus.structures;

public class FactorArray<T> implements IArray<T> {

    public T[] array;
    int factor;
    int size = 0;

    public FactorArray() {
        this.factor = 2;
        array = (T[]) (new Object[10]);
        this.size = 0;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    /**
     * N * logN
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
        T[] newArray = (T[]) (new Object[size() * factor + 1]);
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
