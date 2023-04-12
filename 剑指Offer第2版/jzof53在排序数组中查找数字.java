package 剑指Offer第2版;

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        int count = 0;
        while (l < len && nums[l] == target) {
            count++;
            l++;
        }

        return count;
    }
}
