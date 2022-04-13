class Solution {
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int tmp, max = 0;
            for (int j = 1; j <= i/2; j++) {
                tmp = Math.max(dp[j], j) * Math.max(dp[i - j], i - j);
                max = Math.max(max, tmp);
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
