package ru.otus.dynamicproggramming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.dynamicprogramming.HouseRobber;

public class HouseRobberTest {

    private HouseRobber houseRobber;

    @Before
    public void init() {
        houseRobber = new HouseRobber();
    }

    @Test
    public void houseRobberTest1() {
        int[] nums = new int[] {1, 2, 3, 1};
        int answer = houseRobber.rob(nums);
        Assert.assertEquals(4, answer);
    }

    @Test
    public void houseRobberTest2() {
        int[] nums = new int[] {2, 7, 9, 3, 1};
        int answer = houseRobber.rob(nums);
        Assert.assertEquals(12, answer);
    }

    @Test
    public void houseRobberTest3() {
        int[] nums = new int[] {1, 7, 4, 3, 9, 2};
        int answer = houseRobber.rob(nums);
        Assert.assertEquals(16, answer);
    }
}
