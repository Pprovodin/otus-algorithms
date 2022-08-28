package ru.otus.power;


import ru.otus.fibonacci.Matrix2D;

import java.util.ArrayList;

/**
 * This class contains different types of algorithms to raise number to a power.
 */
public class PowerCalculator {

    /**
     *
     * A straightforward algorithm (iterative) (time - O(N); space - O(1))
     * @param number - number to be raised
     * @param power - power
     * @return - result number
     */
    public double calculatePower(double number, int power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        return result;
    }

    /**
     * An algorithm of raising number to power through binary decomposition of number (time - O(logN); space - O(1)).
     * @param number - number to be raised
     * @param power - power
     * @return double
     */
    public double calculatePowerThroughBinary(double number, int power) {
        double d = number;
        double p = power % 2 == 1 ? number : 1;

        while (power >= 1) {
            power /= 2;
            d *= d;
            if (power % 2 == 1) {
                p *= d;
            }
        }
        return p;
    }

    /**
     * An algorithm of raising matrix to power through binary decomposition of number (time - O(logN); space - O(1)).
     * @param matrix - number to be raised
     * @param power - power
     * @return double
     */
    public Matrix2D calculatePowerThroughBinary(Matrix2D matrix, int power) {
        Matrix2D d = matrix;
        Matrix2D p = power % 2 == 1 ? matrix : Matrix2D.MATRIX_IDENTITY;

        while (power >= 1) {
            power /= 2;
            d = d.multiply(d);
            if (power % 2 == 1) {
                p = p.multiply(d);
            }
        }
        return p;
    }

    // ================================================================================================================

    // Below code shows step-by-step representation of the above algorithm
    // 1. Find binary representation of power like power of 2 (100 = 64 + 32 + 4 + 2 or 2^6 + 2^5 + 2^2 + 2^1)
    // 2. Calculate power only for 2^n powers (O(logN))
    // 3. Multiply all results

    public double calculatePowerStepByStep(double number, int power) {
        ArrayList<Integer> powersOfTwo = calculateBinaryDecompositionOfNumber(power);

        return powersOfTwo.stream().mapToDouble(p -> calculatePowerOfTwo(number, p))
                .reduce(1, (a, b) -> a * b);
    }

    /**
     * An algorithm to find binary decomposition of any number
     * @param number
     * @return - array of powers of 2
     */
    public ArrayList<Integer> calculateBinaryDecompositionOfNumber(int number) {
        ArrayList<Integer> result = new ArrayList<>();
        int d = 1;

        if (number % 2 == 1) {
            result.add(1);
        }

        while (number >= 1) {
            number /= 2;
            d *= 2;
            if (number % 2 == 1) {
                result.add(d);
            }
        }

        return result;
    }

    /**
     * An algorithm for raising a number to a power of 2 (time - O(logN); space - O(1))
     * @param number - number to be raised
     * @param power - power
     * @return - result number
     *
     * throws IllegalArgumentException
     */
    public double calculatePowerOfTwo(double number, int power) {
        if (isPowerOfTwo(power)) {
            int calculationCount = (int) (Math.log(power) / Math.log(2));

            for (int i = 0; i < calculationCount; i++) {
                number *= number;
            }
            return number;
        } else {
            throw new IllegalArgumentException("Power can only be the power of two");
        }
    }

    /**
     * Method check if the number is power of two
     * @param number - number to be raised
     * @return - true/false
     */
    public boolean isPowerOfTwo(int number) {
        return (number != 0) && ((number & (number - 1)) == 0);
    }
}
