package ru.otus.dynamicprogramming.islands;

public class IslandsCounter {
    int[][] square;
    int n;
    
    public int countIslands(int[][] square) {
        this.square = square;
        this.n = square.length;
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.square[i][j] == 1) {
                    islands++;
                    walk(i, j);
                }
            }
        }
        return islands;
    }

    private void walk(int x, int y)  {
        if (x < 0 || x >= n) return;
        if (y < 0 || y >= n) return;
        if (square[x][y] == 0) return;
        square[x][y] = 0;
        walk(x + 1, y);
        walk(x - 1, y);
        walk(x, y + 1);
        walk(x, y - 1);
    }
}
