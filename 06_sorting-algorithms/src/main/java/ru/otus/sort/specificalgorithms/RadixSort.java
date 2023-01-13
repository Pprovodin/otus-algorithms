package ru.otus.sort.specificalgorithms;

import ru.otus.sort.Sort;

import java.util.Arrays;

public class RadixSort extends Sort {

    public RadixSort(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        int maximumNumber = findMaximumNumberIn(array);
        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);
        int placeValue = 1;
        while (numberOfDigits-- > 0) {
            applyCountingSortOn(array, placeValue);
            placeValue *= 10;
        }
    }

    private static int calculateNumberOfDigitsIn(int number) {
        return (int) Math.log10(number) + 1; // valid only if number > 0
    }

    private static int findMaximumNumberIn(int[] arr) {
        return Arrays.stream(arr).max().orElseThrow(() -> new RuntimeException("There is no max"));
    }

    private static void applyCountingSortOn(int[] numbers, int placeValue) {
        int range = 10; // radix or the base

        int length = numbers.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        for (int i = 0; i < length; i++) {
            int digit = (numbers[i] / placeValue) % range;
            frequency[digit]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (numbers[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = numbers[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }
}
