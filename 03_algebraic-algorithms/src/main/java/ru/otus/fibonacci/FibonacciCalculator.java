package ru.otus.fibonacci;

import ru.otus.power.PowerCalculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class FibonacciCalculator {

    PowerCalculator powerCalculator = new PowerCalculator();

    public BigInteger calculateFibonacciCycle(int index) {
        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        BigInteger next = null;

        if (index < 0) {
            throw new IllegalArgumentException("Wrong input");
        }
        if (index < 2) return BigInteger.valueOf(index);

        for (int i = 2; i <= index; i++) {
            next = previous.add(current);
            previous = current;
            current = next;
        }

        return next;
    }

    public BigInteger calculateFibonacciRecursive(int index) {
        if (index == 0) return BigInteger.ZERO;
        if (index == 1 || index == 2) return BigInteger.ONE;

        return calculateFibonacciRecursive(index - 1).add(calculateFibonacciRecursive(index - 2));
    }

    public BigInteger calculateFibonacciGoldenRation(int index) {
        if (index == 0) return BigInteger.ZERO;
        BigDecimal sqrtFive = BigDecimal.valueOf(5).sqrt(new MathContext(10));
        BigDecimal phi = (BigDecimal.valueOf(1).add(sqrtFive))
                .divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
        return phi.pow(index).divide(sqrtFive, RoundingMode.HALF_UP).add(BigDecimal.valueOf(0.5)).toBigInteger();
    }

    public BigInteger calculateFibonacciMatrix(int index) {
        if (index == 0) return BigInteger.ZERO;
        Matrix2D result = powerCalculator.calculatePowerThroughBinary(Matrix2D.MATRIX_BASE, index - 1);
        return result.getElement(0, 0);
    }
}
