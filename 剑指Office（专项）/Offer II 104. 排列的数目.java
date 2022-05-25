class Solution {
    int count;
    public int combinationSum4(int[] nums, int target) {
        bfs(nums, target);
        return count;
    }

    public void bfs(int[] nums,int target){
        if (target < 0) {
            return;
        }
        if (target == 0) {
            count++;
            return;
        }
        for (int num : nums) {
            bfs(nums, target - num);
        }
    }
}

class Solution2 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int num : nums){
                if(num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
