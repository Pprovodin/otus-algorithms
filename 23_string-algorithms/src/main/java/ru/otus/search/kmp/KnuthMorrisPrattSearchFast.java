package ru.otus.search.kmp;

import org.apache.commons.lang3.StringUtils;
import ru.otus.search.SearchPattern;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KnuthMorrisPrattSearchFast implements SearchPattern {
    private static final String SPECIAL_SYMBOL = "@";

    @Override
    public int search(String text, String mask) {
        String fullText = mask + SPECIAL_SYMBOL + text;
        int[] pi = createPiSlow(fullText);

        int answer = findIncreasingSequenceInArray(pi, mask.length());

        return answer == -1 ? -1 : answer - mask.length() - 2;
    }

    private int findIncreasingSequenceInArray(int[] array, int limit) {
        int[] subArray = IntStream.range(1, limit + 1).toArray();
        List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> subArrayList = Arrays.stream(subArray).boxed().collect(Collectors.toList());
        return Collections.indexOfSubList(arrayList, subArrayList);
    }

    // Time complexity - O(mask)
    // Space complexity - O(mask)
    private int[] createPiSlow(String mask) {
        int[] pi = new int[mask.length() + 1];
        pi[1] = 0;
        for (int q = 1; q < mask.length(); q++) {
            int len = pi[q];
            while (len > 0 && mask.charAt(len) != mask.charAt(q))
                len = pi[len];
            if (mask.charAt(len) == mask.charAt(q))
                len++;
            pi[q + 1] = len;
        }

        return pi;
    }

    public static void main(String[] args) {
        String text = "AABCBABCCABCC";
        String mask = "ABC";
        KnuthMorrisPrattSearchFast knuthMorrisPrattSearchFast = new KnuthMorrisPrattSearchFast();

        int pi = knuthMorrisPrattSearchFast.search(text, mask);
        System.out.println(pi);
    }
}
