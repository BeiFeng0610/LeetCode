class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        if (k == 0 || len == 0) {
            return 0;
        }
        int count = 0;
        int l = 0, r = 0, num = 1;
        // 定义左边界，得到最大宽度
        for (r = 0; r < len; r++) {
            num *= nums[r];
            while (l <= r && num >= k){
                num /= nums[l++];
            }
            // 记录符合的组合，因为子组合也符合，所以r - l + 1，每次左边界回收都记录累加。
            if (l <= r) {
                count += r - l + 1;
            }
        }

        return count;
    }
}
