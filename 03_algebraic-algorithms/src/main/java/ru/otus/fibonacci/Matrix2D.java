package ru.otus.fibonacci;

import lombok.Getter;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

@Getter
public class Matrix2D {

    public static final Matrix2D MATRIX_IDENTITY = new Matrix2D(new BigInteger[][] {{BigInteger.ONE, BigInteger.ZERO},
            {BigInteger.ZERO, BigInteger.ONE}});
    public static final Matrix2D MATRIX_ZERO = new Matrix2D(new BigInteger[][] {{BigInteger.ZERO, BigInteger.ZERO},
            {BigInteger.ZERO, BigInteger.ZERO}});
    public static final Matrix2D MATRIX_BASE = new Matrix2D(new BigInteger[][] {{BigInteger.ONE, BigInteger.ONE},
            {BigInteger.ONE, BigInteger.ZERO}});
    private final int numberOfRows;
    private final int numberOfColumns;
    private final BigInteger[][] matrix;

    public Matrix2D() {
        matrix = new BigInteger[][] {{BigInteger.ZERO, BigInteger.ZERO},
            {BigInteger.ZERO, BigInteger.ZERO}};
        numberOfRows = 2;
        numberOfColumns = 2;
    }

    public Matrix2D(BigInteger[][] matrix) {
        this.matrix = matrix;
        this.numberOfRows = matrix.length;
        this.numberOfColumns = matrix[0].length;
    }

    public void assignElement(BigInteger value, int i, int j) {
        matrix[i][j] = value;
    }

    public BigInteger getElement(int i, int j) {
        return matrix[i][j];
    }

    public Matrix2D multiply(Matrix2D matrix) {
        Matrix2D result = new Matrix2D();

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                BigInteger sum = BigInteger.ZERO;
                for (int k = 0; k < numberOfRows; k++) {
                    sum = sum.add(this.getElement(i, k).multiply(matrix.getElement(k, j)));
                }
                result.assignElement(sum, i, j);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix2D matrix2D = (Matrix2D) o;
        return numberOfRows == matrix2D.numberOfRows && numberOfColumns == matrix2D.numberOfColumns && Arrays.deepEquals(matrix, matrix2D.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder b = new StringBuilder();
        b.append('[');

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                b.append(this.getElement(i, j));
                if (j < 1) b.append(", ");
            }
            if (i < 1) b.append("\n");
        }
        return b.append(']').toString();
    }
}
