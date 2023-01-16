package ru.otus.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VectorArrayTest {

    public static VectorArray<Integer> array;

    @Before
    public void init() {
        array = new VectorArray<>(100);
        array.put(1);
        array.put(2);
        array.put(3);
        array.put(4);
    }

    @Test
    public void testGet() {
        Integer expected = 1;
        Integer actual = array.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPut() {
        VectorArray<Integer> expected = new VectorArray<>(new Integer[] {1, 2, 3, 4, 33});
        array.put(33);
        Assert.assertEquals(expected, array);
        Assert.assertEquals(5, array.size());
    }

    @Test
    public void testPutWithIndex() {
        VectorArray<Integer> expected = new VectorArray<>(new Integer[] {1, 2, 33, 3, 4});
        array.put(33, 2);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void testPutWithIndexZero() {
        VectorArray<Integer> expected = new VectorArray<>(new Integer[] {33, 1, 2, 3, 4});
        array.put(33, 0);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void testPutWithIndexLast() {
        VectorArray<Integer> expected = new VectorArray<>(new Integer[] {1, 2, 3, 4, 33});
        array.put(33, 4);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void testRemoveWithIndex() {
        VectorArray<Integer> expected = new VectorArray<>(new Integer[] {1, 2, 4});
        array.remove(2);
        Assert.assertEquals(expected, array);
    }
}
