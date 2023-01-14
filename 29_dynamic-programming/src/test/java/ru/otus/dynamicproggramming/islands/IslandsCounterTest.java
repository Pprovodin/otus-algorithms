package ru.otus.dynamicproggramming.islands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.dynamicprogramming.islands.IslandsCounter;

public class IslandsCounterTest {

    private IslandsCounter islandsCounter;

    @Before
    public void init() {
        islandsCounter = new IslandsCounter();
    }

    @Test
    public void countIslandsTest1() {
        int[][] initialData = new int[][] {{1, 0, 0, 1, 1},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}};

        Assert.assertEquals(3, islandsCounter.countIslands(initialData));
    }

    @Test
    public void countIslandsTest2() {
        int[][] initialData = new int[][] {{1, 1, 1, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 0, 1, 1}};

        Assert.assertEquals(2, islandsCounter.countIslands(initialData));
    }
}
