package ru.otus.primes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.primes.PrimeNumberCalculator;

public class PrimeNumberCalculatorTest {

    PrimeNumberCalculator primeNumberCalculator;

    @Before
    public void init() {
        primeNumberCalculator = new PrimeNumberCalculator();
    }

    @Test
    public void checkCountPrimeNumbers() {
        Assert.assertEquals(4, primeNumberCalculator.countPrimeNumbers(10));
        Assert.assertEquals(25, primeNumberCalculator.countPrimeNumbers(100));
        Assert.assertEquals(168, primeNumberCalculator.countPrimeNumbers(1000));
        Assert.assertEquals(1229, primeNumberCalculator.countPrimeNumbers(10_000));
        // too long
        //Assert.assertEquals(9592, primeNumberCalculator.countPrimeNumbers(100_000));
        //Assert.assertEquals(78498, primeNumberCalculator.countPrimeNumbers(1_000_000));
    }

    @Test
    public void checkCountPrimeNumbersDividePrime() {
        Assert.assertEquals(4, primeNumberCalculator.countPrimeNumbersDividePrime(10));
        Assert.assertEquals(25, primeNumberCalculator.countPrimeNumbersDividePrime(100));
        Assert.assertEquals(168, primeNumberCalculator.countPrimeNumbersDividePrime(1000));
        Assert.assertEquals(1229, primeNumberCalculator.countPrimeNumbersDividePrime(10_000));
        Assert.assertEquals(9592, primeNumberCalculator.countPrimeNumbersDividePrime(100_000));
        Assert.assertEquals(78498, primeNumberCalculator.countPrimeNumbersDividePrime(1_000_000));
        // too long
        //Assert.assertEquals(664579, primeNumberCalculator.countPrimeNumbersDividePrime(10_000_000));
        //Assert.assertEquals(5761455, primeNumberCalculator.countPrimeNumbersDividePrime(100_000_000));
        //Assert.assertEquals(50847534, primeNumberCalculator.countPrimeNumbersDividePrime(1_000_000_000));
    }

    @Test
    public void checkCountPrimeNumbersEratosphene() {
        Assert.assertEquals(4, primeNumberCalculator.countPrimeNumbersEratosphene(10));
        Assert.assertEquals(25, primeNumberCalculator.countPrimeNumbersEratosphene(100));
        Assert.assertEquals(168, primeNumberCalculator.countPrimeNumbersEratosphene(1000));
        Assert.assertEquals(1229, primeNumberCalculator.countPrimeNumbersEratosphene(10_000));
        Assert.assertEquals(9592, primeNumberCalculator.countPrimeNumbersEratosphene(100_000));
        Assert.assertEquals(78498, primeNumberCalculator.countPrimeNumbersEratosphene(1_000_000));
        // too long
        //Assert.assertEquals(664579, primeNumberCalculator.countPrimeNumbersEratosphene(10_000_000));
        //Assert.assertEquals(5761455, primeNumberCalculator.countPrimeNumbersEratosphene(100_000_000));
        //Assert.assertEquals(50847534, primeNumberCalculator.countPrimeNumbersEratosphene(1_000_000_000));
    }

    @Test
    public void checkCountPrimeNumbersEratospheneOptimization() {
        Assert.assertEquals(4, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(10));
        Assert.assertEquals(25, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(100));
        Assert.assertEquals(168, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(1000));
        Assert.assertEquals(1229, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(10_000));
        Assert.assertEquals(9592, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(100_000));
        // too long
        //Assert.assertEquals(78498, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(1_000_000));
        //Assert.assertEquals(664579, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(10_000_000));
        //Assert.assertEquals(5761455, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(100_000_000));
        //Assert.assertEquals(50847534, primeNumberCalculator.countPrimeNumbersEratospheneOptimization(1_000_000_000));
    }
}
