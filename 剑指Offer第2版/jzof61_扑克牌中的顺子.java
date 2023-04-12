package 剑指Offer第2版;

class Solution {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int min = 0,pre = 0;
        for (int i = 0; i < 5; i++) {
            if (min == 0) {
                min = nums[i];
                pre = min;
            } else if (nums[i] == pre) {
                return false;
            } else {
                pre = nums[i];
            }
        }
        if (nums[4] - min > 4) {
            return false;
        }
        return true;
    }
}
