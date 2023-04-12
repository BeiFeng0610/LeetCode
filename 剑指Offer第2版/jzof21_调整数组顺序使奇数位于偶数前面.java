package 剑指Offer第2版;

class Solution {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int l = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 != 0) {
                int tmp = nums[l];
                nums[l++] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }
}
