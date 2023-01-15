package ru.otus.search.boyermoore;

import ru.otus.search.SearchPattern;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreSearch implements SearchPattern {
    @Override
    public int search(String text, String mask) {
        char[] textAsCharArray = text.toCharArray();
        char[] maskAsCharArray = mask.toCharArray();
        int n = textAsCharArray.length;
        int m = maskAsCharArray.length;
        if (m == 0) return 0;
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            last.put(textAsCharArray[i], -1);
        }
        for (int i = 0; i < m; i++) {
            last.put(maskAsCharArray[i], i);
        }
        int i = m - 1;
        int k = m - 1;
        while (i < n) {
            if (textAsCharArray[i] == maskAsCharArray[k]) {
                if (k == 0) {
                    return i;
                }
                i--;
                k--;
            } else {
                i += m - Math.min(k, 1 + last.get(textAsCharArray[i]));
                k = m - 1;
            }
        }
        return -1;
    }
}
