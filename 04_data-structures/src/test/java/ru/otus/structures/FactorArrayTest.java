package ru.otus.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactorArrayTest {

    public static FactorArray<Integer> array;

    @Before
    public void init() {
        array = new FactorArray<>();
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
        FactorArray<Integer> expected = new FactorArray<>(new Integer[] {1, 2, 3, 4, 33});
        array.put(33);
        Assert.assertEquals(expected, array);
        Assert.assertEquals(5, array.size());
    }

    @Test
    public void testPutWithIndex() {
        FactorArray<Integer> expected = new FactorArray<>(new Integer[] {1, 2, 33, 3, 4});
        array.put(33, 2);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void testPutWithIndexZero() {
        FactorArray<Integer> expected = new FactorArray<>(new Integer[] {33, 1, 2, 3, 4});
        array.put(33, 0);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void testPutWithIndexLast() {
        FactorArray<Integer> expected = new FactorArray<>(new Integer[] {1, 2, 3, 4, 33});
        array.put(33, 4);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void testRemoveWithIndex() {
        FactorArray<Integer> expected = new FactorArray<>(new Integer[] {1, 2, 4});
        array.remove(2);
        Assert.assertEquals(expected, array);
    }
}
