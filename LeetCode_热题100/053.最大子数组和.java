class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int cur = nums[0];
        int ans = cur;
        for (int i = 1; i < len; i++) {
            // 记录当前连续子序列和，因为至少包括一个数，所以存在负数。
            // 计算新的 cur 时，判断上一次为负，就不添加运算了。
            cur = Math.max(0, cur) + nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}