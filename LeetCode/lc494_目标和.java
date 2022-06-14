package LeetCode;

class Solution {
    /*
    * 可以使用回溯的方法遍历所有的表达式，
    *   回溯过程中维护一个计数器 count
    *   当遇到一种表达式的结果等于目标数 target时，将 count的值加 1。
    * */
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        beiBao(nums, target, 0, 0);
        return count;
    }

    public void beiBao(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            beiBao(nums, target, idx + 1, sum + nums[idx]);
            beiBao(nums, target, idx + 1, sum - nums[idx]);
        }
    }

}
