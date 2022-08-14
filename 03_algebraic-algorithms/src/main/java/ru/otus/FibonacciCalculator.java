package ru.otus;

public class FibonacciCalculator {

    public int calculateFibonacciCycle(int index) {
        int previous = 1;
        int current = 1;

        if (index < 0) {
            throw new IllegalArgumentException("Wrong input");
        }
        if (index < 2) {
            return current;
        }

        int currentOld;
        for (int i = 1; i < index; i++) {
            currentOld = current;
            current += previous;
            previous = currentOld;
        }

        return current;
    }

    public int calculateFibonacciRecursive(int index) {
        if (index < 2) {
            return 1;
        }

        return calculateFibonacciRecursive(index - 1) + calculateFibonacciRecursive(index - 2);
    }
}
