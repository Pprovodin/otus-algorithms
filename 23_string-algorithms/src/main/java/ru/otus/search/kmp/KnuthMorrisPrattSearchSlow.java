package ru.otus.search.kmp;

import org.apache.commons.lang3.StringUtils;
import ru.otus.search.SearchPattern;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KnuthMorrisPrattSearchSlow implements SearchPattern {
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

    // O(mask^3)
    public int[] createPiSlow(String mask) {
        int[] pi = new int[mask.length() + 1];

        for (int q = 0; q <= mask.length(); q++) {
            String line = StringUtils.left(mask, q);

            for (int len = 0; len < q; len++) {
                if (StringUtils.left(line, len).equals(StringUtils.right(line, len))) {
                    pi[q] = len;
                }
            }
        }

        return pi;
    }
}
