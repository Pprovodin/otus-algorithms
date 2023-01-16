package ru.otus.structures;

import java.util.ArrayList;

public class FactorJavaArray<T> implements IArray<T> {

    ArrayList<T> arrayList;

    public FactorJavaArray() {
        arrayList = new ArrayList<>();
    }

    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public void put(T item) {
        arrayList.add(item);
    }

    @Override
    public void put(T item, int index) {
        arrayList.add(index, item);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public T remove(int index) {
        return arrayList.remove(index);
    }
}
