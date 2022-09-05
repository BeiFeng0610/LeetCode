class Solution {
    public int climbStairs(int n) {
        int l = 0, r = 0, ans = 1;
        for (int i = 1; i <= n; i++) {
            l = r;
            r = ans;
            ans = l + r;
        }
        return ans;
    }
}
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
