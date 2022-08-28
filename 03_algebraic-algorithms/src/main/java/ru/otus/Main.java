package ru.otus;

import org.apache.commons.lang3.time.StopWatch;
import ru.otus.fibonacci.FibonacciCalculator;
import ru.otus.primes.PrimeNumberCalculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        PrimeNumberCalculator primeNumberCalculator = new PrimeNumberCalculator();
        List<Integer> indexes = new ArrayList<>(List.of(10, 100, 1000, 10_000, 100_000, 1_000_000));

        System.out.println("====Fibonacci Matrix====");
        for (Integer index : indexes) {
            stopWatch.reset();
            stopWatch.start();
            fibonacciCalculator.calculateFibonacciMatrix(index);
            stopWatch.stop();
            System.out.println("N=" + index + "; time spent " + stopWatch.getTime() + "ms");
        }

        System.out.println();
        System.out.println("====Fibonacci Cycle====");
        for (Integer index : indexes) {
            stopWatch.reset();
            stopWatch.start();
            fibonacciCalculator.calculateFibonacciCycle(index);
            stopWatch.stop();
            System.out.println("N=" + index + "; time spent " + stopWatch.getTime() + "ms");
        }

        indexes.add(10_000_000);
        System.out.println();
        System.out.println();
        System.out.println("====Prime numbers Eratosphene====");
        for (Integer index : indexes) {
            stopWatch.reset();
            stopWatch.start();
            int result = primeNumberCalculator.countPrimeNumbersEratosphene(index);
            stopWatch.stop();
            System.out.println("N=" + index + "; time spent " + stopWatch.getTime() + "ms; result = " + result);
        }

        System.out.println();
        System.out.println("====Prime numbers only-primes-division====");
        for (Integer index : indexes) {
            stopWatch.reset();
            stopWatch.start();
            int result = primeNumberCalculator.countPrimeNumbersDividePrime(index);
            stopWatch.stop();
            System.out.println("N=" + index + "; time spent " + stopWatch.getTime() + "ms; result = " + result);
        }

        System.out.println();
        System.out.println("====Prime numbers Eratosphene O(N)====");
        for (Integer index : indexes) {
            stopWatch.reset();
            stopWatch.start();
            int result = primeNumberCalculator.countPrimeNumbersEratospheneOptimization(index);
            stopWatch.stop();
            System.out.println("N=" + index + "; time spent " + stopWatch.getTime() + "ms; result = " + result);
        }
    }
}
