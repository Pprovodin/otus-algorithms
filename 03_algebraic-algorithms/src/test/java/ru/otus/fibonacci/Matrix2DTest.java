package ru.otus.fibonacci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class Matrix2DTest {

    public Matrix2D matrix2D;

    @Before
    public void init() {
        matrix2D = new Matrix2D();
    }

    @Test
    public void checkMultiplication() {
        Assert.assertArrayEquals(Matrix2D.MATRIX_IDENTITY.getMatrix(),
                Matrix2D.MATRIX_IDENTITY.multiply(Matrix2D.MATRIX_IDENTITY).getMatrix());
        Assert.assertArrayEquals(Matrix2D.MATRIX_ZERO.getMatrix(),
                Matrix2D.MATRIX_IDENTITY.multiply(Matrix2D.MATRIX_ZERO).getMatrix());
        Assert.assertArrayEquals(Matrix2D.MATRIX_BASE.getMatrix(),
                Matrix2D.MATRIX_IDENTITY.multiply(Matrix2D.MATRIX_BASE).getMatrix());

        BigInteger[][] firstMultiply = new BigInteger[][] {{BigInteger.valueOf(2), BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(1)}};
        Assert.assertArrayEquals(new Matrix2D(firstMultiply).getMatrix(),
                Matrix2D.MATRIX_BASE.multiply(Matrix2D.MATRIX_BASE).getMatrix());

    }
}
