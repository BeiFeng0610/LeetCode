class Solution {
    public void sortColors(int[] nums) {
        int rIdx = 0, wIdx = 0, bIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果下标相同，依次覆盖
            if (nums[i] == 0) {
                nums[bIdx++] = 2;
                nums[wIdx++] = 1;
                nums[rIdx++] = 0;
            } else if (nums[i] == 1) {
                nums[bIdx++] = 2;
                nums[wIdx++] = 1;
            } else {
                nums[bIdx++] = 2;
            }
        }
    }
}