package ru.otus.structures;

public class MatrixArray<T> implements IArray<T> {

    int size;
    int vector;
    IArray<T[]> array;

    public MatrixArray() {
        this.size = 0;
        this.vector = 100;
        this.array = new FactorArray<>();
    }


    @Override
    public T get(int index) {
        return array.get(index / vector)[index % vector];
    }

    @Override
    public void put(T item) {
        if (size == array.size() * vector) {
            array.put((T[]) new Object[vector]);
        }

        array.get(size / vector)[size % vector] = item;
        size++;
    }

    @Override
    public void put(T item, int index) {

    }

    @Override
    public int size() {
        return size;
    }
}
