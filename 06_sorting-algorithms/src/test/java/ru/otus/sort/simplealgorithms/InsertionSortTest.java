package ru.otus.sort.simplealgorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.sort.Sort;

public class InsertionSortTest {

    private int[] array;
    private final int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Before
    public void init() {
        array = new int[]{4, 5, 3, 1, 7, 8, 9, 2, 6};
    }

    @Test
    public void shouldBeSorted() {
        Sort insertionSort = new InsertionSort(array);
        insertionSort.sort();
        Assert.assertArrayEquals(sortedArray, array);
    }
}
