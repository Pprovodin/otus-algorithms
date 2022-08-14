package ru.otus;

public class PrimeNumberCalculator {

    public int countPrimeNumbers(int limit) {
        int count = 0;
        boolean prime;
        for (int number = 2; number <= limit; number++) {
            prime = true;
            for (int divider = 2; divider < number; divider++) {
                if (number % divider == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                count++;
            }
        }

        return count;
    }
}
