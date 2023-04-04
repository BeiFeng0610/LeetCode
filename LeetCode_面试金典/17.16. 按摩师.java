class Solution {
    public int massage(int[] nums) {
        int prepre = 0, pre = 0;
        for (int num : nums) {
            int cur = Math.max(prepre + num, pre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}