class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 2) {
                nums[blue++] = 2;
            } else if (num == 1) {
                nums[blue++] = 2;
                nums[white++] = 1;
            } else {
                nums[blue++] = 2;
                nums[white++] = 1;
                nums[red++] = 0;
            }
        }
    }
}