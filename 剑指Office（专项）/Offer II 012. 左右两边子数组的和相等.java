class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0, pre = 0;
        for (int num : nums) {
            sum += num;// 记录总和
        }
        // 从0开始判断除0下标两边的和，相等则返回
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
