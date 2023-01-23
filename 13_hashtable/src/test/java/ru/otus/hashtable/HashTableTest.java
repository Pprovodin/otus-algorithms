package ru.otus.hashtable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {

    private HashTable<Integer, String> hashTable;

    @Before
    public void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    public void size() {
        hashTable.put(1, "1");
        hashTable.put(3, "3");
        hashTable.put(5, "5");
        hashTable.put(3, "6");

        Assert.assertEquals(3, hashTable.size());
    }

    @Test
    public void resize() {
        hashTable = new HashTable<>(5);
        hashTable.put(10, "10");
        hashTable.put(20, "20");
        hashTable.put(30, "30");
        hashTable.put(40, "40");

        Assert.assertEquals("10", hashTable.get(10));
        Assert.assertEquals("20", hashTable.get(20));
        Assert.assertEquals("30", hashTable.get(30));
        Assert.assertEquals("40", hashTable.get(40));
    }

    @Test
    public void put_new() {
        Assert.assertNull(hashTable.get(1));
        hashTable.put(1, "1");
        Assert.assertEquals("1", hashTable.get(1));
    }

    @Test
    public void put_existing() {
        hashTable.put(1, "1");
        hashTable.put(1, "2");

        Assert.assertEquals("2", hashTable.get(1));
    }

    @Test
    public void put_result() {
        Assert.assertNull(hashTable.put(2, "2"));
        Assert.assertEquals("2", hashTable.put(2, "3"));
    }

    @Test
    public void get() {
        hashTable.put(-100, "100");

        Assert.assertEquals("100", hashTable.get(-100));
    }

    @Test
    public void get_not_existing() {
        Assert.assertNull(hashTable.get(-100));
    }

    @Test
    public void remove() {
        hashTable.put(1, "1");
        hashTable.put(2, "2");
        hashTable.put(3, "3");

        Assert.assertEquals("2", hashTable.remove(2));
        Assert.assertNull(hashTable.get(2));
    }
}
