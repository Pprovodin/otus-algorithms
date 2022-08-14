package ru.otus;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PowerCalculatorTest {

    PowerCalculator powerCalculator;

    @Before
    public void init() {
        powerCalculator = new PowerCalculator();
    }

    @Test
    public void checkCalculatePower() {
        Assert.assertEquals(8, powerCalculator.calculatePower(2, 3), 0.00001);
        Assert.assertEquals(1.25 * 1.25 * 1.25, powerCalculator.calculatePower(1.25, 3), 0.00001);
    }
}
