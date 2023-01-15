package ru.otus.search;

public interface SearchPattern {
    /**
     * t
     * 0123456789x1
     * STRONGSTRING
     * RING
     * m
     * @param text - incoming string
     * @param mask - pattern to search
     * @return - index of the first element
     */
    int search(String text, String mask);
}
