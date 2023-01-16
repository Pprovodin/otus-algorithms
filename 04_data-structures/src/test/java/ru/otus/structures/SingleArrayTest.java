package ru.otus.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SingleArrayTest {

    public static IArray<Integer> single;

    @Before
    public void init() {
        single = new SingleArray<>();
        single.put(1);
        single.put(2);
        single.put(3);
        single.put(4);
    }

    @Test
    public void testGet() {
        Integer expected = 1;
        Integer actual = single.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPut() {
        SingleArray<Integer> expected = new SingleArray<>(new Integer[] {1, 2, 3, 4, 33});
        single.put(33);
        Assert.assertEquals(expected, single);
    }

    @Test
    public void testPutWithIndex() {
        SingleArray<Integer> expected = new SingleArray<>(new Integer[] {1, 2, 33, 3, 4});
        single.put(33, 2);
        Assert.assertEquals(expected, single);
    }

    @Test
    public void testPutWithIndexZero() {
        SingleArray<Integer> expected = new SingleArray<>(new Integer[] {33, 1, 2, 3, 4});
        single.put(33, 0);
        Assert.assertEquals(expected, single);
    }

    @Test
    public void testPutWithIndexLast() {
        SingleArray<Integer> expected = new SingleArray<>(new Integer[] {1, 2, 3, 4, 33});
        single.put(33, 4);
        Assert.assertEquals(expected, single);
    }

    @Test
    public void testRemoveWithIndex() {
        SingleArray<Integer> expected = new SingleArray<>(new Integer[] {1, 2, 4});
        single.remove(2);
        Assert.assertEquals(expected, single);
    }
}
