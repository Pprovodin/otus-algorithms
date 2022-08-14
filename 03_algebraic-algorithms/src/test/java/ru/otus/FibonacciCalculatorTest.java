package ru.otus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciCalculatorTest {

    FibonacciCalculator fibonacciCalculator;

    @Before
    public void init() {
        fibonacciCalculator = new FibonacciCalculator();
    }

    @Test
    public void checkCalculateFibonacciCycle() {
        Assert.assertEquals(1, fibonacciCalculator.calculateFibonacciCycle(0));
        Assert.assertEquals(1, fibonacciCalculator.calculateFibonacciCycle(1));
        Assert.assertEquals(2, fibonacciCalculator.calculateFibonacciCycle(2));
        Assert.assertEquals(3, fibonacciCalculator.calculateFibonacciCycle(3));
        Assert.assertEquals(5, fibonacciCalculator.calculateFibonacciCycle(4));
        Assert.assertEquals(8, fibonacciCalculator.calculateFibonacciCycle(5));
        Assert.assertEquals(13, fibonacciCalculator.calculateFibonacciCycle(6));
        Assert.assertEquals(21, fibonacciCalculator.calculateFibonacciCycle(7));
    }

    @Test
    public void checkCalculateFibonacciRecursive() {
        Assert.assertEquals(1, fibonacciCalculator.calculateFibonacciRecursive(0));
        Assert.assertEquals(1, fibonacciCalculator.calculateFibonacciRecursive(1));
        Assert.assertEquals(2, fibonacciCalculator.calculateFibonacciRecursive(2));
        Assert.assertEquals(3, fibonacciCalculator.calculateFibonacciRecursive(3));
        Assert.assertEquals(5, fibonacciCalculator.calculateFibonacciRecursive(4));
        Assert.assertEquals(8, fibonacciCalculator.calculateFibonacciRecursive(5));
        Assert.assertEquals(13, fibonacciCalculator.calculateFibonacciRecursive(6));
        Assert.assertEquals(21, fibonacciCalculator.calculateFibonacciRecursive(7));
    }
}
