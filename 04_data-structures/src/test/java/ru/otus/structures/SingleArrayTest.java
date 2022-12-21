package ru.otus.structures;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SingleArrayTest {

    public static SingleArray<Integer> single;

    @BeforeClass
    public static void init() {
        single = new SingleArray<>();
        single.put(1);
        single.put(2);
        single.put(3);
        single.put(4);
    }

    @Test
    public void testPutWithIndex() {
        single.put(33, 2);
        List<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};

        String s = list.toString();
        System.out.println(s);
    }
}
