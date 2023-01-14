package ru.otus.dynamicprogramming.onetwopeas;

import java.util.Arrays;

public class OneTwoPeas {

    private final Nod nodCalculator;

    public OneTwoPeas(Nod nodCalculator) {
        this.nodCalculator = nodCalculator;
    }

    public String sharePeas(String string) {
        Integer[] data = parseData(string);
        int a = data[0];
        int b = data[1];
        int c = data[2];
        int d = data[3];

        int numerator = a*d + c*b;
        int denominator = b*d;
        int nod = nodCalculator.calculateNod(numerator, denominator);

        int reducesNumerator = numerator / nod;
        int reducesDenominator = denominator / nod;

        return reducesNumerator + "/" + reducesDenominator;
    }

    public static Integer[] parseData(String string) {
        String[] array = string.split("(\\+)|(/)", 4);
        return Arrays.stream(array).map(Integer::parseInt).toArray(Integer[]::new);
    }
}
