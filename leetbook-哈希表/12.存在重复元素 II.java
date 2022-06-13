class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // i 大于 k 说明窗口大于k了，删除窗口的第一个元素
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            // 如果窗口内包含，则true
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
