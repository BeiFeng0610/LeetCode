class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        int pre = 0;
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = dp[i];
        }
        int l = dp[nums.length - 1];
        pre = 0;
        cur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            dp[i] = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = dp[i];
        }
        return Math.max(l, dp[dp.length - 2]);
    }
}
