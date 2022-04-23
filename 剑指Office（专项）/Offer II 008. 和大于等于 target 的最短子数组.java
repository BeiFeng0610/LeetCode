class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int l = 0, r = 0;
        int sum = nums[0], ans = Integer.MAX_VALUE;
        while (l<=r) {
            if (sum < target) {
                if (r + 1 < len) {
                    sum += nums[++r];
                } else {
                    break;
                }
            } else {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
