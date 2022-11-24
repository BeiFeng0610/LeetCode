class Solution {
    public int rob(int[] nums) {
        int prep = 0, pre = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num + prep);
            prep = pre;
            pre = max;
        }
        return max;
    }
}