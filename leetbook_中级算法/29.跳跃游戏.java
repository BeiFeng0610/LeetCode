class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true;
        }
        int pre = Math.max(0, nums[0]);
        for (int i = 1; i < len; i++) {
            if (pre == 0) {
                return false;
            }
            pre = Math.max(nums[i], pre - 1);
        }
        return true;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
