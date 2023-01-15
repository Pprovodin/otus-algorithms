package ru.otus.search;

public class BruteForceReverseSearch implements SearchPattern {
    // O(M*(T - M + 1))
    @Override
    public int search(String text, String mask) {
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = mask.length() - 1;
            while (m >= 0 && text.charAt(t + m) == mask.charAt(m)) {
                m--;
            }
            if (m < 0)
                return t;
            t++;
        }
        return -1;
    }
}
