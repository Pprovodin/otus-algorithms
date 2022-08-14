package ru.otus;

import org.apache.commons.lang3.StringUtils;

public class LuckyTicket {

    public static void main(String[] args) {
        System.out.println(getLuckyCount(3));
    }

    public static long getLuckyCount(int n) {
        long limit = (long) Math.pow(10, n*2);
        long sum = 0;
        for (long i = 0; i < limit; i++) {
            String number;
            if (String.valueOf(i).length() < n*2)
                number = StringUtils.repeat("0", n*2 - String.valueOf(i).length()) + i;
            else
                number = String.valueOf(i);

            char[] firstPart = number.substring(0, n).toCharArray();
            char[] secondPart = number.substring(n).toCharArray();

            long sumFirstPart = 0;
            long sumSecondPart = 0;

            for (int j = 0; j < n; j++) {
                sumFirstPart += Character.getNumericValue(firstPart[j]);
                sumSecondPart += Character.getNumericValue(secondPart[j]);
            }


            if (sumFirstPart == sumSecondPart) {
                sum++;
            }

        }

        return sum;
    }
}
