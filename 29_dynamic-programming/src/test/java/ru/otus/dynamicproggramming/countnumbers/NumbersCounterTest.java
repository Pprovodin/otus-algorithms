package ru.otus.dynamicproggramming.countnumbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.dynamicprogramming.countnumbers.NumbersCounter;

public class NumbersCounterTest {

    private NumbersCounter numbersCounter;

    @Before
    public void init() {
        numbersCounter = new NumbersCounter();
    }

    @Test
    public void countNumbersTest1() {
        Assert.assertEquals(2, numbersCounter.countNumbers(1));
    }

    @Test
    public void countNumbersTest2() {
        Assert.assertEquals(4, numbersCounter.countNumbers(2));
    }

    @Test
    public void countNumbersTest3() {
        Assert.assertEquals(6, numbersCounter.countNumbers(3));
    }

    @Test
    public void countNumbersTest4() {
        Assert.assertEquals(10, numbersCounter.countNumbers(4));
    }

    @Test
    public void countNumbersTest5() {
        Assert.assertEquals(16, numbersCounter.countNumbers(5));
    }

    @Test
    public void countNumbersTest10() {
        Assert.assertEquals(178, numbersCounter.countNumbers(10));
    }
}
