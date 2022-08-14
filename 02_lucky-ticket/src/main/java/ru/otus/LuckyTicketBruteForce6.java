package ru.otus;

import org.apache.commons.lang3.StringUtils;

/**
 * In this class represented different methods that return number of lucky tickets for 6-digit (only!!!) tickets
 */
public class LuckyTicketBruteForce6 {

    /**
     * Complexity O(10^N) where N = 6
     * @return number of lucky tickets for 6-digit tickets
     */
    public int getLuckyTicket() {
        int count = 0;

        for (int a1 = 0; a1 <= 9; a1++) {
            for (int a2 = 0; a2 <= 9; a2++) {
                for (int a3 = 0; a3 <= 9; a3++) {
                    int sumA = a1 + a2 + a3;
                    for (int b1 = 0; b1 <= 9; b1++) {
                        for (int b2 = 0; b2 <= 9; b2++) {
                            for (int b3 = 0; b3 <= 9; b3++) {
                                int sumB = b1 + b2 + b3;

                                if (sumA == sumB) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * Complexity O(10^(N-1)) where N = 6
     * @return number of lucky tickets for 6-digit tickets
     */
    public int getLuckyTicketFirstOptimization() {
        int count = 0;

        for (int a1 = 0; a1 <= 9; a1++) {
            for (int a2 = 0; a2 <= 9; a2++) {
                for (int a3 = 0; a3 <= 9; a3++) {
                    int sumA = a1 + a2 + a3;
                    for (int b1 = 0; b1 <= 9; b1++) {
                        for (int b2 = 0; b2 <= 9; b2++) {
                            int b3 = sumA - b1 - b2;
                            if (b3 >= 0 && b3 <= 9) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * Complexity O(10^N) where N = 6
     * @return number of lucky tickets for 6-digit tickets
     */
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
