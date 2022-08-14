package ru.otus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LuckyTicketsForNTest {

    LuckyTicketsForN luckyTicketsForN;

    @Before
    public void init() {
        luckyTicketsForN = new LuckyTicketsForN();
    }

    @Test
    public void checkSumOfDigits() {
        Assert.assertEquals(3, luckyTicketsForN.sumOfDigits(3));
        Assert.assertEquals(5, luckyTicketsForN.sumOfDigits(5));
        Assert.assertEquals(1, luckyTicketsForN.sumOfDigits(10));
        Assert.assertEquals(2, luckyTicketsForN.sumOfDigits(11));
        Assert.assertEquals(18, luckyTicketsForN.sumOfDigits(99));
        Assert.assertEquals(54, luckyTicketsForN.sumOfDigits(999999));
        Assert.assertEquals(4, luckyTicketsForN.sumOfDigits(1111));
        Assert.assertEquals(45, luckyTicketsForN.sumOfDigits(123456789));
    }

    @Test
    public void checkCountOfSums() {
        Assert.assertEquals(1, luckyTicketsForN.countSums(2, 0));
        Assert.assertEquals(9, luckyTicketsForN.countSums(2, 10));
        Assert.assertEquals(4, luckyTicketsForN.countSums(2, 3));
        Assert.assertEquals(8, luckyTicketsForN.countSums(2, 7));
        Assert.assertEquals(1, luckyTicketsForN.countSums(2, 18));
    }
}
