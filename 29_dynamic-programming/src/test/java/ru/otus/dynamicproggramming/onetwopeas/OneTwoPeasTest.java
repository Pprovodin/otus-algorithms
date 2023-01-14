package ru.otus.dynamicproggramming.onetwopeas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.dynamicprogramming.onetwopeas.NodCalculator;
import ru.otus.dynamicprogramming.onetwopeas.OneTwoPeas;

public class OneTwoPeasTest {

    private OneTwoPeas oneTwoPeas;

    @Before
    public void init() {
        NodCalculator nodCalculator = new NodCalculator();
        oneTwoPeas = new OneTwoPeas(nodCalculator);
    }

    @Test
    public void OneTwoPeasTest1() {
        String initialData = "2/100+3/100";
        String answer = oneTwoPeas.sharePeas(initialData);

        Assert.assertEquals("1/20", answer);
    }

    @Test
    public void OneTwoPeasTest2() {
        String initialData = "1/2+1/5";
        String answer = oneTwoPeas.sharePeas(initialData);

        Assert.assertEquals("7/10", answer);
    }

    @Test
    public void OneTwoPeasTest3() {
        String initialData = "1/10000+9999/10000";
        String answer = oneTwoPeas.sharePeas(initialData);

        Assert.assertEquals("1/1", answer);
    }

    @Test
    public void OneTwoPeasTest4() {
        String initialData = "1/10000+9999/10000";
        String answer = oneTwoPeas.sharePeas(initialData);

        Assert.assertEquals("1/1", answer);
    }

    @Test
    public void OneTwoPeasTest5() {
        String initialData = "1/2+5/15";
        String answer = oneTwoPeas.sharePeas(initialData);

        Assert.assertEquals("5/6", answer);
    }
}
