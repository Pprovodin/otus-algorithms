package ru.otus.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.Arrays;
import java.util.stream.IntStream;

@SuppressWarnings("UnstableApiUsage")
public class Main {

    private static final int FILTER_SIZE = 1_000;
    private static final int ABSENT_ARRAY_SIZE = 500;

    public static void main(String[] args) {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), FILTER_SIZE, 0.1);

        int[] present = IntStream.range(0, FILTER_SIZE).toArray();
        Arrays.stream(present).forEach(filter::put);

        int[] absent = IntStream.range(FILTER_SIZE, FILTER_SIZE + ABSENT_ARRAY_SIZE).toArray();

        double answer = countAccuracy(filter, present, absent);
        System.out.println(answer);
    }

    public static double countAccuracy(BloomFilter<Integer> bloomFilter, int[] present, int[] absent) {
        int n_total_positives = 0;
        int n_false_positives = 0;

        int[] allElements = unionArrays(present, absent);

        for (Integer element : allElements) {
            if (bloomFilter.mightContain(element)) {
                n_total_positives += 1;
                if (Arrays.stream(absent).anyMatch(e -> e == element)) n_false_positives += 1;

            }
        }
        return (double) n_false_positives / (double) n_total_positives * 100;

    }

    public static int[] unionArrays(int[] firstArray, int[] secondArray) {
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;
        int[] result = new int[firstArrayLength + secondArrayLength];
        System.arraycopy(firstArray, 0, result, 0, firstArrayLength);
        System.arraycopy(secondArray, 0, result, firstArrayLength, secondArrayLength);
        return result;
    }

}
