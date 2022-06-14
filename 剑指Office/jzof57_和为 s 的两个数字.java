package 剑指Office;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int s = nums[l] + nums[r];
            if (s < target) {
                l++;
            } else if (s > target) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            } 
        }
        return new int[0];
    }

}
