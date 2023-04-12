package 剑指Offer第2版;

class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return l;
    }
}
