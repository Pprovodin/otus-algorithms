package ru.otus.primes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeNumberCalculator {

    int[] primes;

    public int countPrimeNumbers(int limit) {
        int count = 0;
        for (int number = 2; number <= limit; number++) {
            if (isPrimeStraightForward(number)) {
                count++;
            }
        }
        return count;
    }

    public int countPrimeNumbersDividePrime(int limit) {
        primes = new int[limit / 2];
        int count = 0;
        for (int number = 2; number <= limit; number++) {
            if (isPrimeDividePrimes(number)) {
                primes[count++] = number;
            }
        }
        return count;
    }

    /**
     * Eratosphene's sieve to count prime numbers O(N*log(logN)).
     * @param limit - number to define if it's prime
     * @return count
     */
    public int countPrimeNumbersEratosphene(int limit) {
        boolean[] numbers = new boolean[limit + 1];
        int count = 0;
        int sqrtLimit = (int) Math.sqrt(limit);

        for (int i = 2; i <= limit; i++) {
            if (!numbers[i]) {
                count++;
                if (i <= sqrtLimit) {
                    for (int j = i * i; j <= limit; j += i) {
                        numbers[j] = true;
                    }
                }
            }
        }
        return count++;
    }

    /**
     * Eratosphene's sieve to count prime numbers O(N) optimization (this method requires O(N) space complexity).
     * @param limit - number to define if it's prime
     * @return count
     */
    public int countPrimeNumbersEratospheneOptimization(int limit) {
        int lp[] = new int[limit+1];
        List<Integer> pr = new ArrayList<>(limit / 2);
        for (int i = 2; i <= limit; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                pr.add(i);
            }
            for (Integer p : pr) {
                if (p <= lp[i] && (long) p * (long) i <= limit) {
                    lp[p * i] = p;
                }
            }
        }
        return pr.size();
    }


    /**
     * Straight forward algorithm to define if number is prime O(N^2).
     * @param number - number to define if it's prime
     * @return boolean
     */
    public boolean isPrimeStraightForward(int number) {
        int count = 0;
        for (int divider = 1; divider <= number; divider++) {
            if (number % divider == 0) count++;
        }
        return count == 2;
    }

    /**
     * Straight forward algorithm to define if number is prime O(N^2).
     * A number is prime when it can be divided only by itself and 1. So we can change logic of IF-statement:
     * if we get into IF-statement number is not prime
     * @param number - number to define if it's prime
     * @return boolean
     */
    public boolean isPrimeSkipBoundaries(int number) {
        for (int divider = 2; divider < number; divider++) {
            if (number % divider == 0) return false;
        }
        return true;
    }

    /**
     * Straight forward algorithm to define if number is prime O(N^2).
     * 1. A number is prime when it can be divided only by itself and 1. So we can change logic of IF-statement:
     *    if we get into IF-statement number is not prime.
     * 2. Also, we can skip all even numbers immediately. And set upper limit to N/2.
     * @param number - number to define if it's prime
     * @return boolean
     */
    public boolean isPrimeSkipBoundariesAndEven(int number) {
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int divider = 3; divider < number / 2; divider += 2) {
            if (number % divider == 0) return false;
        }
        return true;
    }

    /**
     * Straight forward algorithm to define if number is prime O(N^(1.5)).
     * 1. A number is prime when it can be divided only by itself and 1. So we can change logic of IF-statement:
     *    if we get into IF-statement number is not prime.
     * 2. Also, we can skip all even numbers immediately. And set upper limit to sqrt(N).
     * @param number - number to define if it's prime
     * @return boolean
     */
    public boolean isPrimeSkipBoundariesAndEvenSqrt(int number) {
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        int limit = (int) Math.sqrt(number);
        for (int divider = 3; divider <= limit; divider += 2) {
            if (number % divider == 0) return false;
        }
        return true;
    }

    /**
     * Straight forward algorithm to define if number is prime O(N*logN).
     * 1. A number is prime when it can be divided only by itself and 1. So we can change logic of IF-statement:
     *    if we get into IF-statement number is not prime.
     * 2. Also, we can skip all even numbers immediately. And set upper limit to sqrt(N).
     * 3. We can remember all previous prime numbers and set divider only to the primes.
     *    If number / 21, then number / 3 and number / 7, so 21 can be skipped.
     * @param number - number to define if it's prime
     * @return boolean
     */
    public boolean isPrimeDividePrimes(int number) {
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        int limit = (int) Math.sqrt(number);
        for (int i = 0; primes[i] <= limit; i++) {
            if (number % primes[i] == 0) return false;
        }
        return true;
    }
}
