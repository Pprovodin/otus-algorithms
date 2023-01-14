package ru.otus.barn;

import java.util.Random;

public interface BarnSolution {
    int solve();

    static boolean[][] generateMap(int size, int fillDensity, int seed) {
        boolean[][] map = new boolean[size][size];
        Random random = new Random(seed);
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                map[x][y] = random.nextInt(fillDensity) == 0;
            }
        }
        return map;
    }
}
