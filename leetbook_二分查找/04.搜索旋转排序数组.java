class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (target == nums[mid]) {
                return mid;
            }
            // 如果左边界小于 mid，target又大于等于 左边界，小于mid，右边界收敛
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                // 如果左边界大于 mid，target大于mid，但是小于有边界，左边界收敛
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }
}