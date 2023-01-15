package ru.otus.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BruteForceSearchTest {

    SearchPattern searchPattern;

    @Before
    public void init() {
        searchPattern = new BruteForceSearch();
    }

    @Test
    public void searchTest1() {
        String text = "STRONGSTRING";
        String mask = "RING";

        Assert.assertEquals(8, searchPattern.search(text, mask));
    }

    @Test
    public void searchTest2() {
        String text = "ABC@ABBDABCABABCD";
        String mask = "ABCD";

        Assert.assertEquals(13, searchPattern.search(text, mask));
    }
}
