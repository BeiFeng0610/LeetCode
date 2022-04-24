class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0, pre = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < len; i++) {
            sum -= nums[i];
            if (sum == pre) {
                return i;
            }
            pre += nums[i];
        }
        return -1;
    }
}
