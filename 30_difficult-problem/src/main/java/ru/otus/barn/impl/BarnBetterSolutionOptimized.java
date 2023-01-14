package ru.otus.barn.impl;

import ru.otus.barn.BarnSolution;

public class BarnBetterSolutionOptimized implements BarnSolution {
    int size;
    boolean[][] map;
    int[] line;

    public BarnBetterSolutionOptimized(boolean[][] map) {
        this.size = map.length;
        this.map = map;
        this.line = new int[size];
    }

    public int solve() {
        int maxSquare = 0;
        for (int y = 0; y < size; y++) {
            calculateLineHeight(y); // N^2 + N^3
            for (int x = 0; x < size; x++) {
                int square = findSquareAt(x, y);
                if (maxSquare < square)
                    maxSquare = square;
            }
        }
        return maxSquare;
    }

    private void calculateLineHeight(int y) {
        for (int x = 0; x < size; x++) {
            if(map[x][y])
                line[x] = 0;
            else
                line[x]++;
        }
    }

    private int findSquareAt(int x, int y) {
        int maxSquare = 0;
        int limHeight = size;
        for (int width = 1; x + width - 1 < size; width++) {
            int height = line[x + width - 1];
            if (height == 0) break; //big improve!!!
            if (limHeight > height)
                limHeight = height;

            int square = width * limHeight;
            if (maxSquare < square)
                maxSquare = square;
        }

        return maxSquare;
    }
}
