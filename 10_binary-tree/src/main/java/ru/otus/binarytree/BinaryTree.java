package ru.otus.binarytree;

public interface BinaryTree<T extends Comparable<? super T>> {
    boolean isEmpty();
    void insert(T item);
    void remove(T item);
    boolean contains(T item);
    int getHeight();
    void clear();
}
