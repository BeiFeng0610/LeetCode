class Solution {
    public void sortColors(int[] nums) {
        int rdx = 0, wdx = 0, bdx = 0;
        for (int num : nums) {
            if (num == 0) {
                nums[bdx++] = 2;
                nums[wdx++] = 1;
                nums[rdx++] = 0;
            } else if (num == 1) {
                nums[bdx++] = 2;
                nums[wdx++] = 1;
            } else {
                nums[bdx++] = 2;
            }
        }
    }
}