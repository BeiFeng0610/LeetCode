class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        // 动态规划，找到两个前置结点，计算哪个最小即可
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (cost.length == i ? 0 : cost[i]);
        }
        return dp[cost.length];
    }
}
