class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = len - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }


        }

        return -1;
    }
}