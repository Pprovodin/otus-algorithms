package ru.otus.search.boyermoore;

import ru.otus.search.SearchPattern;

import java.util.Arrays;

public class BoyerMooreHorspoolSearch implements SearchPattern {

    // Worst Time Complexity - O(T*M)
    // Average Time Complexity - O(T)!!!
    // Space Complexity - O(T)
    @Override
    public int search(String text, String mask) {
        int[] shift = createShift(mask);
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = mask.length() - 1;
            while (m >= 0 && text.charAt(t + m) == mask.charAt(m)) {
                m--;
            }
            if (m < 0)
                return t;
            t += shift[text.charAt(t + mask.length() - 1)];
        }
        return -1;
    }

    private int[] createShift(String mask) {
        int[] shift = new int[128];
        Arrays.fill(shift, mask.length());
        for (int m = 0; m < mask.length() - 1; m++) {
            shift[mask.charAt(m)] = mask.length() - m - 1;
        }
        return shift;
    }
}
