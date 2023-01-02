package 剑指Offer;

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
