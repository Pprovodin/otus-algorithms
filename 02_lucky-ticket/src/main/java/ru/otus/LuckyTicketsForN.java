package ru.otus;

import lombok.Getter;

import java.math.BigInteger;

/**
 * In this class represented different methods that return number of lucky tickets for N*2-digit (only!!!) tickets
 * example: N = 3 - when 6-digit tickets considered
 */
@Getter
public class LuckyTicketsForN {

    private BigInteger count = BigInteger.ZERO;

    /**
     * Recursion algorithm: Complexity O(100^N) where N = (number of digits)/2
     */
    public void getLuckyTicketsRecursion(int N, int sumFirstHalf, int sumSecondHalf) {

        if (N == 0) {
            if (sumFirstHalf == sumSecondHalf) {
                count = count.add(count);
            }
            return;
        }

        for (int firstDigitInFirstPart = 0; firstDigitInFirstPart <= 9; firstDigitInFirstPart++) {
            for (int firstDigitInSecondPart = 0; firstDigitInSecondPart <= 9; firstDigitInSecondPart++) {
                getLuckyTicketsRecursion(N - 1, sumFirstHalf + firstDigitInFirstPart, sumSecondHalf + firstDigitInSecondPart);
            }
        }
    }

    /**
     * Recursion algorithm: Complexity O(90*N^2) where N = (number of digits)/2
     */
    public void getLuckyTicketCleverRecursion(int N) {
        for (int i = 0; i <= 9 * N; i++) {
            int countOfSums = countSums(N, i);
            BigInteger countOfSumsBigInteger = BigInteger.valueOf(countOfSums);
            count = count.add(countOfSumsBigInteger.multiply(countOfSumsBigInteger));
        }
    }

    public int countSums(int N, int sum) {
        int limit = (int) Math.pow(10, N);
        int count = 0;

        for (int i = 0; i < limit; i++) {
            if (sumOfDigits(i) == sum) {
                count++;
            }
        }

        return count;
    }

    public int sumOfDigits(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        return sumOfDigits;
    }
}
