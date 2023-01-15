package ru.otus.search;

public class BruteForceSearch implements SearchPattern {

    // O(M*(T - M + 1))
    @Override
    public int search(String text, String mask) {
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = 0;
            while (m < mask.length() && text.charAt(t + m) == mask.charAt(m)) {
                m++;
            }
            if (m == mask.length())
                return t;
            t++;
        }
        return -1;
    }
}
