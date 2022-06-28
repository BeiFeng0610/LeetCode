class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums[0] < nums[len - 1]) {
            return nums[0];
        }
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            // 两边相等，要么全相等，要么旋转过，找到一个不同的数
            if (nums[l] == nums[r]) {
                l++;
            }else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}