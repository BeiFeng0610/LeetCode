class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums[0] < nums[len - 1]) {
            return nums[0];
        }
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
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