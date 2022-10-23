class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int midNum = nums[mid];
            int leftNum = nums[left];
            int rightNum = nums[right];
            if (midNum == target) {
                return mid;
            }
            if (leftNum == target) {
                return left;
            }
            if (rightNum == target) {
                return right;
            }

            if (midNum > leftNum) {
                if (target < midNum && target > leftNum) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > midNum && target < leftNum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int midNum = nums[mid];

            if (midNum == target) {
                return mid;
            }

            if (midNum > nums[left]) {
                if (target < midNum && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > midNum && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}