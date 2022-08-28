class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[left] == target && nums[right] == target) {
                return new int[]{left, right};
            } else {
                if (nums[left] != target) {
                    left++;
                } else {
                    right--;
                }
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }

        }
        return new int[]{-1, -1};
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true) + 1;
        int rightIdx = binarySearch(nums, target, false);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
