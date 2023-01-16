package ru.otus.structures;

import org.junit.Before;
import org.junit.Test;

public class MatrixArrayTest {

    public static MatrixArray<Integer> array;

    @Before
    public void init() {
        array = new MatrixArray<>(4);
        array.put(1);
        array.put(2);
        array.put(3);
        array.put(4);
        array.put(5);
        array.put(6);
        array.put(7);
        array.put(8);
        array.put(9);
        array.put(10);
        array.put(11);
        array.put(12);
    }

    @Test
    public void testPut() {
        System.out.println(array);
        array.put(0, 6);
        System.out.println(array);
    }

    @Test
    public void testPutBroadCase() {
        System.out.println(array);
        array.put(0, 7);
        System.out.println(array);
    }

    @Test
    public void testRemove() {
        System.out.println(array);
        System.out.println(array.size());
        array.remove(6);
        System.out.println(array);
        System.out.println(array.size());
    }

    @Test
    public void testRemoveBroadCase() {
        System.out.println(array);
        System.out.println(array.size());
        array.remove(7);
        System.out.println(array);
        System.out.println(array.size());
    }

    @Test
    public void testRemoveFirstElement() {
        System.out.println(array);
        System.out.println(array.size());
        array.remove(0);
        System.out.println(array);
        System.out.println(array.size());
    }

    @Test
    public void testRemoveLastElement() {
        System.out.println(array);
        System.out.println(array.size());
        array.remove(array.size() - 1);
        System.out.println(array);
        System.out.println(array.size());
    }

}
