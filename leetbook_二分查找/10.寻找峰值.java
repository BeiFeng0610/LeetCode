class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int l = 0, r = len - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid - 1] > nums[mid]) {
                r = mid;
            } else if (nums[mid - 1] < nums[mid]) {
                l = mid;
            }
        }

        return nums[l] < nums[r] ? r : l;
    }
}