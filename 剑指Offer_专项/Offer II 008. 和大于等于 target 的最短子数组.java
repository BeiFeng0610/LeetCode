class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int l = 0, r = 0;
        int sum = nums[0], ans = Integer.MAX_VALUE;
        // 设定边界
        while (l<=r) {
            // 总数小于，右边界右移
            if (sum < target) {
                if (r + 1 < len) {
                    sum += nums[++r];
                } else {
                    break;
                }
            // 记录最小长度，左边界右移
            } else {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
