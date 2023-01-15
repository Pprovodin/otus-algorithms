package ru.otus.search.boyermoore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.search.SearchPattern;

public class BoyerMooreSearchTest {

    SearchPattern searchPattern;

    @Before
    public void init() {
        searchPattern = new BoyerMooreSearch();
    }

    @Test
    public void searchTest1() {
        String text = "STRONGSTRING";
        String mask = "RING";

        Assert.assertEquals(8, searchPattern.search(text, mask));
    }

    @Test
    public void searchTest2() {
        String text = "AABCBABCCABCC";
        String mask = "ABC";

        Assert.assertEquals(1, searchPattern.search(text, mask));
    }

    @Test
    public void searchTest3() {
        String text = "AAAAAABCCABCC";
        String mask = "ABC";

        Assert.assertEquals(5, searchPattern.search(text, mask));
    }

    @Test
    public void searchTest4() {
        String text = "AAAAAAAAAABCC";
        String mask = "ABC";

        Assert.assertEquals(9, searchPattern.search(text, mask));
    }

    @Test
    public void searchTest5() {
        String text = "AAAAAAAAAAABC";
        String mask = "ABC";

        Assert.assertEquals(10, searchPattern.search(text, mask));
    }

    @Test
    public void searchTest6() {
        String text = "ABCABC";
        String mask = "ABC";

        Assert.assertEquals(0, searchPattern.search(text, mask));
    }

    @Test
    public void searchTest7() {
        String text = "ABC@ABBDABCABABCD";
        String mask = "ABCD";

        Assert.assertEquals(13, searchPattern.search(text, mask));
    }
}
