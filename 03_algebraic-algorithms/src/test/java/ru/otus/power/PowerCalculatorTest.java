package ru.otus.power;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.fibonacci.Matrix2D;
import ru.otus.power.PowerCalculator;

import java.math.BigInteger;
import java.util.List;

public class PowerCalculatorTest {

    PowerCalculator powerCalculator;
    Matrix2D matrix2D;

    @Before
    public void init() {
        powerCalculator = new PowerCalculator();
        matrix2D = new Matrix2D();
    }

    @Test
    public void checkCalculatePower() {
        Assert.assertEquals(8, powerCalculator.calculatePower(2, 3), 0.000001);
        Assert.assertEquals(1.25 * 1.25 * 1.25, powerCalculator.calculatePower(1.25, 3), 0.000001);
    }

    @Test
    public void checkCalculatePowerThroughBinary() {
        Assert.assertEquals(Math.pow(2, 3),
                powerCalculator.calculatePowerThroughBinary(2, 3), 0.000001);
        Assert.assertEquals(Math.pow(2, 4),
                powerCalculator.calculatePowerThroughBinary(2, 4), 0.000001);
        Assert.assertEquals(Math.pow(1.25, 3),
                powerCalculator.calculatePowerThroughBinary(1.25, 3), 0.000001);
    }

    @Test
    public void checkCalculatePowerMatrix() {
        Assert.assertArrayEquals(Matrix2D.MATRIX_IDENTITY.getMatrix(),
                powerCalculator.calculatePowerThroughBinary(Matrix2D.MATRIX_IDENTITY, 5).getMatrix());
        Assert.assertArrayEquals(Matrix2D.MATRIX_ZERO.getMatrix(),
                powerCalculator.calculatePowerThroughBinary(Matrix2D.MATRIX_ZERO, 5).getMatrix());

        BigInteger[][] firstMultiply = new BigInteger[][] {{BigInteger.valueOf(2), BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(1)}};

        Assert.assertArrayEquals(new Matrix2D(firstMultiply).getMatrix(),
                powerCalculator.calculatePowerThroughBinary(Matrix2D.MATRIX_BASE, 2).getMatrix());
    }

    @Test
    public void checkIsPowerOfTwo() {
        Assert.assertTrue(powerCalculator.isPowerOfTwo(1));
        Assert.assertTrue(powerCalculator.isPowerOfTwo(2));
        Assert.assertTrue(powerCalculator.isPowerOfTwo(4));
        Assert.assertTrue(powerCalculator.isPowerOfTwo(8));
        Assert.assertTrue(powerCalculator.isPowerOfTwo(64));
        Assert.assertTrue(powerCalculator.isPowerOfTwo(512));
        Assert.assertTrue(powerCalculator.isPowerOfTwo(2048));

        Assert.assertFalse(powerCalculator.isPowerOfTwo(0));
        Assert.assertFalse(powerCalculator.isPowerOfTwo(3));
        Assert.assertFalse(powerCalculator.isPowerOfTwo(17));
        Assert.assertFalse(powerCalculator.isPowerOfTwo(511));
    }

    @Test
    public void checkCalculatePowerOfTwo() {
        Assert.assertEquals( 65536.0, powerCalculator.calculatePowerOfTwo(4., 8), 0.000001);
        Assert.assertEquals( 4.0, powerCalculator.calculatePowerOfTwo(4., 1), 0.000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCalculatePowerOfTwoThrowsException() {
        powerCalculator.calculatePowerOfTwo(4., 7);
    }

    @Test
    public void checkCalculateBinaryDecompositionOfNumber() {
        Assert.assertEquals(List.of(4, 32, 64), powerCalculator.calculateBinaryDecompositionOfNumber(100));
        Assert.assertEquals(List.of(512), powerCalculator.calculateBinaryDecompositionOfNumber(512));
        Assert.assertEquals(List.of(1, 2, 32, 64), powerCalculator.calculateBinaryDecompositionOfNumber(99));
        Assert.assertEquals(List.of(1, 2, 4, 8, 16, 32, 64, 128, 256, 512),
                powerCalculator.calculateBinaryDecompositionOfNumber(1023));
        Assert.assertEquals(List.of(2),
                powerCalculator.calculateBinaryDecompositionOfNumber(2));
        Assert.assertEquals(List.of(1),
                powerCalculator.calculateBinaryDecompositionOfNumber(1));
    }

    @Test
    public void checkCalculatePowerStepByStep() {
        Assert.assertEquals(Math.pow(2, 3),
                powerCalculator.calculatePowerStepByStep(2, 3), 0.000001);
        Assert.assertEquals(Math.pow(2, 4),
                powerCalculator.calculatePowerStepByStep(2, 4), 0.000001);
        Assert.assertEquals(Math.pow(1.25, 3),
                powerCalculator.calculatePowerStepByStep(1.25, 3), 0.000001);
        Assert.assertEquals(Math.pow(1.25, 1),
                powerCalculator.calculatePowerStepByStep(1.25, 1), 0.000001);
    }
}
