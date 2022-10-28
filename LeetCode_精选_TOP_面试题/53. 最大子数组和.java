class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max((pre + num), num);
            max = Math.max(pre, max);
        }
        return max;
    }
}