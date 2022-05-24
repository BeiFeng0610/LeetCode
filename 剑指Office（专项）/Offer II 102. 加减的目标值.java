// 耗时上天了
class Solution {
    int[] nums;
    int target;
    int sum,count;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dfs(0);
        return count;
    }

    public void dfs(int n) {
        if (n == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        sum += nums[n];
        dfs(n + 1);
        sum -= nums[n] * 2;
        dfs(n + 1);
        sum += nums[n];
    }
}

class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}
