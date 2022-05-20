class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int pre = 0;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = dp[i];
        }

        return dp[nums.length - 1];
    }
}
