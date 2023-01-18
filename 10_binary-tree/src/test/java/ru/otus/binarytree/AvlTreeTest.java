package ru.otus.binarytree;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvlTreeTest {

    private BinaryTree<Integer> tree;

    @Before
    public void init() {
        tree = new AvlTree<>();
    }

    @After
    public void destroy() {
        tree.clear();
    }

    @Test
    public void testInsertRandom() {
        tree.insert(4);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);

        Assert.assertEquals("4(7(9)(5))(2(3)(1))", tree.toString());
    }

    @Test
    public void testInsertIncreasing() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        Assert.assertEquals("4(6(7)(5))(2(3)(1))", tree.toString());
    }

    @Test
    public void testRemove() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        Assert.assertTrue(tree.contains(3));

        tree.remove(3);
        Assert.assertEquals("4(6(7)(5))(2()(1))", tree.toString());
        Assert.assertFalse(tree.contains(3));
    }
}