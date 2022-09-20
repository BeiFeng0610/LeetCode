class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[len];
    }
}

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int pre = 0, prep = 0, cur = 0;
        for (int i = 0; i < len; i++) {
            pre = cur;
            cur = Math.max(pre, nums[i] + prep);
            prep = pre;
        }
        return cur;
    }
}