class Solution {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i = Math.max(nums[i], i + 1)) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}