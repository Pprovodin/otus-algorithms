package ru.otus.dynamicproggramming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.dynamicprogramming.HouseRobber;
import ru.otus.dynamicprogramming.LongestIncreasingSubsequence;

public class LongestIncreasingSubsequenceTest {

    private LongestIncreasingSubsequence longestIncreasingSubsequence;

    @Before
    public void init() {
        longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    }

    @Test
    public void longestIncreasingSubsequenceTest1() {
        int[] nums = new int[] {10, 9, 2, 5, 3, 4, 101, 18};
        int answer = longestIncreasingSubsequence.lengthOfLis(nums);
        Assert.assertEquals(4, answer);
    }

    @Test
    public void longestIncreasingSubsequenceTest2() {
        int[] nums = new int[] {0, 1, 0, 3, 2, 3};
        int answer = longestIncreasingSubsequence.lengthOfLis(nums);
        Assert.assertEquals(4, answer);
    }

    @Test
    public void longestIncreasingSubsequenceTest3() {
        int[] nums = new int[] {7, 7, 7, 7, 7, 7};
        int answer = longestIncreasingSubsequence.lengthOfLis(nums);
        Assert.assertEquals(1, answer);
    }
}
