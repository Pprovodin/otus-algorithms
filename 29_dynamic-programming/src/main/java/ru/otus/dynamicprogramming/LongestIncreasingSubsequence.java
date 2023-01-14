package ru.otus.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLis(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int last = 1; last < nums.length; last++) {
            for (int i = 0; i < last; i++) {
                if (nums[i] < nums[last]) {
                    if (dp[last] < dp[i] + 1) {
                        dp[last] = dp[i] + 1;
                    }
                }
            }
        }

        return Arrays.stream(dp).max().orElse(0);
    }
}
