package ru.otus.barn.impl;

public class MyStack {
    int size;
    int[] arr;

    public MyStack(int size) {
        this.size = 0;
        arr = new int[size];
    }

    public boolean empty() {
        return  size == 0;
    }

    public void push(int x) {
        arr[size++] = x;
    }

    public int pop() {
        return arr[--size];
    }

    public int peek() {
        return arr[size - 1];
    }
}
