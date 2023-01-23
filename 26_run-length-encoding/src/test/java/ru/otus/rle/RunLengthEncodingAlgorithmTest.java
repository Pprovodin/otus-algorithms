package ru.otus.rle;

import org.junit.Assert;
import org.junit.Test;

public class RunLengthEncodingAlgorithmTest {
    @Test
    public void encode() {
        final byte[] bytes = new byte[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9};
        final byte[] expected = new byte[]{-1, 1, 3, 2, -4, 3, 4, 5, 6, 3, 7, -2, 8, 9};

        Assert.assertArrayEquals(expected, RunLengthEncodingAlgorithm.encode(bytes));
    }

    @Test
    public void decode() {
        final byte[] bytes = new byte[]{-1, 1, 3, 2, -4, 3, 4, 5, 6, 3, 7, -2, 8, 9};
        final byte[] expected = new byte[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9};

        Assert.assertArrayEquals(expected, RunLengthEncodingAlgorithm.decode(bytes));
    }
}
