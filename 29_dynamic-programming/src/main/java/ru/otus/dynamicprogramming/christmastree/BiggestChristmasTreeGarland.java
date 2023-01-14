package ru.otus.dynamicprogramming.christmastree;

/**
 * @link https://www.robotsharp.info/index.php?page=TaskInfo&taskId=3707
 */
public class BiggestChristmasTreeGarland {

    /**
     * Dynamic Programming Solution (time complexity - O(N^2)) (whereas brute force is O(2^N))
     * @param christmasTree
     * @return
     */
    public int lengthOfChristmasGarland(int[][] christmasTree) {
        int n = christmasTree.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int left = christmasTree[i + 1][j];
                int right = christmasTree[i + 1][j + 1];
                christmasTree[i][j] += Math.max(left, right);
            }
        }
        return christmasTree[0][0];
    }
}
