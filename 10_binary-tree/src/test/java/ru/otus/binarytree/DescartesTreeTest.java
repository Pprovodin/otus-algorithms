package ru.otus.binarytree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DescartesTreeTest {

    private DescartesTree tree;

    @Before
    public void setUp() {
        tree = new DescartesTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        tree.insert(7);
    }

    @Test
    public void insert() {
        final int element = 11;
        tree.insert(element);
        Assert.assertEquals("8(11()(9(10)()))(7)", tree.toString());
    }

    @Test
    public void remove() {
        final int element = 10;

        Assert.assertTrue(tree.contains(element));
        tree.remove(element);
        System.out.println(tree);
    }

    @Test
    public void search() {
        final int key = 100;

        Assert.assertFalse(tree.contains(key));
        tree.insert(key);
        Assert.assertTrue(tree.contains(key));
    }
}
