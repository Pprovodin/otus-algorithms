package ru.otus.structures;

public class SingleArray<T> implements IArray<T> {

    private T[] array;
    private int size;

    public SingleArray() {
        array = (T[]) (new Object[0]);
        size = 0;
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
        array[index] = item;
        System.arraycopy(array, index, newArray, index + 1, size - index);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    public T remove(int index) {
        T oldValue = array[index];
        array[index] = array[size - 1];
        T[] newArray = (T[]) (new Object[size - 1]);
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size - index);

        return oldValue;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
}
