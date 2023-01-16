package ru.otus.structures;

public interface IArray<T> {
    T get(int index);
    void put(T item);
    void put(T item, int index);
    int size();
    T remove(int index);
    default boolean isEmpty() {
        return size() == 0;
    }
}
