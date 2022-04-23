class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || len == 0) {
            return 0;
        }

        int count = 0;
        int l = 0, r = 0, num = 1;
        for (r = 0; r < len; r++) {
            num *= nums[r];
            while (l <= r && num >= k){
                num /= nums[l++];
            }
            if (l <= r) {
                count += r - l + 1;
            }
        }

        return count;
    }
}
