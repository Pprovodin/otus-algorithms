package ru.otus.barn.impl;

import ru.otus.barn.BarnSolution;

public class BarnEasySolution implements BarnSolution {

    boolean[][] map;
    int size;

    public BarnEasySolution(boolean[][] map) {
        this.map = map;
        this.size = map.length;
    }

    @Override
    public int solve() {
        int maxSquare = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < map.length; x++) {
                int square = findSquareAt(x, y);
                if (maxSquare < square)
                    maxSquare = square;
            }
        }
        return maxSquare;
    }

    private int findSquareAt(int x, int y) {
        int maxSquare = 0;
        int limHeight = map.length;
        for (int width = 1; x + width - 1 < map.length; width++) {
            int height = findHeightAt(x + width - 1, y);
            if (limHeight > height)
                limHeight = height;

            int square = width * limHeight;
            if (maxSquare < square)
                maxSquare = square;
        }

        return maxSquare;
    }

    private int findHeightAt(int x, int y) {
        int height = 0;
        while (y - height >= 0 && !map[x][y - height]) {
            height++;
        }

        return height;
    }
}
