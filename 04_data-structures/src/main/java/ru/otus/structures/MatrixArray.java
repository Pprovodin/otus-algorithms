package ru.otus.structures;

@SuppressWarnings("unchecked")
public class MatrixArray<T> implements IArray<T> {

    private int size;
    private int vector;
    private IArray<T[]> array;

    public MatrixArray(int vector) {
        this.size = 0;
        this.vector = vector;
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
        if (size == array.size() * vector) {
            array.put((T[]) new Object[vector]);
        }

        int rowStart = index / vector;
        int colStart = index % vector;

        T previousElement = item;
        T currentElement;

        if (colStart == vector) {
            rowStart++;
            colStart = 0;
        }

        int maxSteps = size - index;
        int count = 0;
        for (int row = rowStart; row < array.size(); row++) {
            //System.arraycopy(array.get(row), index, array.get(row), index + 1, size - index);
            for (int col = colStart; col < array.get(row).length; col++) {
                currentElement = array.get(row)[col];
                array.get(row)[col] = previousElement;
                previousElement = currentElement;
                if (maxSteps == count)
                    break;
                count++;
            }
            colStart = 0;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        int rowStart = index / vector;
        int colStart = index % vector;

        if (colStart == vector) {
            rowStart++;
            colStart = 0;
        }

        T nextElement = null;
        T currentElement;

        int maxSteps = size - index;
        int count = 0;
        int limit;
        for (int row = array.size() - 1; row >= rowStart; row--) {
            if (row != rowStart)
                limit = 0;
            else
                limit = colStart;
            for (int col = array.get(row).length - 1; col >= limit; col--) {
                if (maxSteps == count)
                    break;
                currentElement = array.get(row)[col];
                array.get(row)[col] = nextElement;
                nextElement = currentElement;
                count++;
            }
        }
        size--;
        return nextElement;
    }

    @Override
    public String toString() {
        if (array == null)
            return "null";

        int iMax = size - 1;
        if (iMax == -1)
            return "[[]]";

        int step = 0;

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i <= size / vector; i++) {
            b.append('[');
            for (int j = 0; j < vector; j++) {
                b.append(array.get(i)[j]);
                if (j == vector - 1)
                    b.append("]\n");
                else
                    b.append(", ");
                if (step == iMax)
                    return b.append(']').toString();
                step++;
            }
        }
        return b.append("]").toString();
    }
}
