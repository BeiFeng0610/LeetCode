class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true) + 1;
        int rightIdx = binarySearch(nums, target, false);
        if (leftIdx <= rightIdx && leftIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean tag) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target || (tag && nums[mid] >= target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        int tmp = left;
        if (left >= len || nums[left] != target) {
            return new int[]{-1, -1};
        }
        right = len - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return new int[]{tmp, right};
    }
}