class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[l];
                nums[l++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}