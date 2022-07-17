class Solution {
    public int removeDuplicates(int[] nums) {
        int n = 1, l = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && n < 2) {
                nums[l++] = nums[i];
                n++;
            }
            if (nums[i] > nums[i - 1]) {
                nums[l++] = nums[i];
                n = 1;
            }
        }
        return l;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (nums.length < 2) {
            return len;
        }

        int l = 2;
        for (int i = 2; i < len; i++) {
            if (nums[l - 2] != nums[i]) {
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}