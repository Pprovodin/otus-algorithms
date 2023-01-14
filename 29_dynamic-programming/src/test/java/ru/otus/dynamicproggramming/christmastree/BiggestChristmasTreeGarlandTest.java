package ru.otus.dynamicproggramming.christmastree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.dynamicprogramming.christmastree.BiggestChristmasTreeGarland;

public class BiggestChristmasTreeGarlandTest {

    private BiggestChristmasTreeGarland biggestChristmasTreeGarland;

    @Before
    public void init() {
        biggestChristmasTreeGarland = new BiggestChristmasTreeGarland();
    }

    @Test
    public void lengthOfChristmasGarlandTest1() {
        int[][] christmasTree = new int[][] {{1, 0, 0, 0}, {2, 3, 0, 0}, {4, 5, 6, 0}, {9, 8, 0, 3}};
        int answer = biggestChristmasTreeGarland.lengthOfChristmasGarland(christmasTree);
        Assert.assertEquals(17, answer);
    }

    @Test
    public void lengthOfChristmasGarlandTest2() {
        int[][] christmasTree = new int[][] {{8}};
        int answer = biggestChristmasTreeGarland.lengthOfChristmasGarland(christmasTree);
        Assert.assertEquals(8, answer);
    }

    @Test
    public void lengthOfChristmasGarlandTest3() {
        int[][] christmasTree = new int[][] {{2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 8, 5, 0, 0, 0, 0, 0, 0, 0},
                {8, 3, 6, 7, 0, 0, 0, 0, 0, 0},
                {7, 1, 8, 6, 7, 0, 0, 0, 0, 0},
                {4, 9, 4, 3, 4, 0, 0, 0, 0, 0},
                {9, 4, 5, 9, 5, 0, 2, 0, 0, 0},
                {2, 7, 7, 8, 7, 7, 2, 9, 0, 0},
                {9, 2, 4, 5, 0, 4, 0, 9, 0, 0},
                {8, 6, 2, 3, 2, 5, 3, 0, 0, 5}};
        int answer = biggestChristmasTreeGarland.lengthOfChristmasGarland(christmasTree);
        Assert.assertEquals(60, answer);
    }
}
