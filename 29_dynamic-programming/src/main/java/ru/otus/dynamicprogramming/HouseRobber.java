package ru.otus.dynamicprogramming;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int dp0 = nums[0];
        int dp1 = Math.max(nums[0], nums[1]);
        int dpi = dp1;
        for (int i = 2; i < nums.length; i++) {
            dpi = Math.max(dp1, dp0 + nums[i]);
            dp0 = dp1;
            dp1 = dpi;
        }
        return dpi;
    }
}
