class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int rIdx = 0;

        for (int i = 0; i < len; i++) {
            if (rIdx >= i) {
                rIdx = Math.max(rIdx, i + nums[i]);
                if (rIdx >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Solution {
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
