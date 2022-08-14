package ru.otus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimeNumberCalculatorTest {

    PrimeNumberCalculator primeNumberCalculator;

    @Before
    public void init() {
        primeNumberCalculator = new PrimeNumberCalculator();
    }

    @Test
    public void checkCountPrimeNumbers() {
        Assert.assertEquals(4, primeNumberCalculator.countPrimeNumbers(10));
        Assert.assertEquals(25, primeNumberCalculator.countPrimeNumbers(100));
        Assert.assertEquals(168, primeNumberCalculator.countPrimeNumbers(1000));
        Assert.assertEquals(1229, primeNumberCalculator.countPrimeNumbers(10_000));
        Assert.assertEquals(9592, primeNumberCalculator.countPrimeNumbers(100_000));
        // too long
        //Assert.assertEquals(78498, primeNumberCalculator.countPrimeNumbers(1_000_000));
    }
}
