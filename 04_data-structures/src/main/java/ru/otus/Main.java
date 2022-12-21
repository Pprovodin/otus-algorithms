package ru.otus;

import jdk.dynalink.linker.LinkerServices;
import ru.otus.structures.FactorArray;
import ru.otus.structures.IArray;
import ru.otus.structures.SingleArray;
import ru.otus.structures.VectorArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        IArray<Integer> single = new SingleArray<>();
        IArray<Integer> vector = new VectorArray<>(100);
        IArray<Integer> factor = new FactorArray<>();
        testPut(factor, 100);
        testPut(factor, 1000);
        testPut(factor, 10_000);
        testPut(factor, 100_000);
        testPut(factor, 1_000_000);
    }

    private static void testPut(IArray<Integer> array, int total) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            array.put(j);
        }
        System.out.println(array + " testPut: " + total + " " + (System.currentTimeMillis() - start));
    }
}
