package ru.otus.search.kmp;

import org.apache.commons.lang3.StringUtils;
import ru.otus.search.SearchPattern;

public class KnuthMorrisPrattFiniteMachine implements SearchPattern {

    private static final String ALPHABET = "ABC";

    // O(mask^3 * A) where A - alphabet size
    private int[][] createDelta(String mask) {
        int[][] delta = new int[mask.length()][ALPHABET.length()];
        for (int q = 0; q < mask.length(); q++) {
            for (char a : ALPHABET.toCharArray()) {
                String line = StringUtils.left(mask, q) + a;
                int k = q + 1;
                while (!StringUtils.left(mask, k).equals(StringUtils.right(line, k))) {
                    k--;
                }
                delta[q][a - ALPHABET.charAt(0)] = k;
            }
        }
        return delta;
    }

    @Override
    public int search(String text, String mask) {
        int q = 0;
        int[][] delta = createDelta(mask);
        for (int i = 0; i < text.length(); i++) {
            q = delta[q][text.charAt(i) - ALPHABET.charAt(0)];
            if (q == mask.length()) return i - mask.length() + 1;
        }
        return -1;
    }
}
