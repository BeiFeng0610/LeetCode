class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}