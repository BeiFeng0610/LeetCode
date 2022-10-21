class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0, right = 1;

        while (right < len) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}