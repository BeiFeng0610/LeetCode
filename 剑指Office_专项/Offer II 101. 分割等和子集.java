class Solution {
    public boolean canPartition(int[] nums) {
//        sum用于计算数组数字总和
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
//        数字总和不为偶数直接返回false
        if(sum % 2 == 1){
            return false;
        }else {
//            保存总和的一半也就是两个数组分别要组成的数字总和
            int target = sum / 2;
//            定义dp数组,dp[i][j]表示在nums里选择i个数相加得到的不超过j的最大数,相当于01背包问题的变形
            int[][] dp = new int[nums.length + 1][target + 1];
//            i为0时dp[i][j]一定为0,所以从i为1开始循环直到i等于nums元素个数,表示选择的数字个数从1个数到nums所有元素
            for (int i = 1; i <= nums.length; i++) {
//                j为0时dp[i][j]一定为0,因为要求的最大数不超过j,所以j从1开始循环
                for (int j = 1; j <= target; j++) {
//                    先令dp[i][j] = dp[i - 1][j]表示不选当前数字
                    dp[i][j] = dp[i - 1][j];
//                    数组下标从0开始,所以当前数表示为nums[i - 1]而不是nums[i]
//                    如果j >= nums[i - 1],说明可以添加该数
                    if (j >= nums[i - 1]) {
//                        dp[i][j]的最大值为不选该数时的dp[i - 1][j]和选了该数时的dp[i - 1][j - nums[i - 1]] + nums[i - 1]两者之间的最大值
//                        dp[i - 1][j - nums[i - 1]] + nums[i - 1]表示从i个数中选择i-1个数之和不超过[j - nums[i - 1]]的最大值加上当前值
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                    }
                }
            }
//            返回得到的最大数
            return dp[nums.length][target] == target;
        }

    }
}

