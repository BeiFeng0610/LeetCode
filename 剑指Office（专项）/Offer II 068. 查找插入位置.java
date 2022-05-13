class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            // 左右相等 mid 还小于target，就应该左边界右移，这是插入的位置
            if (nums[mid] < target) {
                l = mid + 1;
                // 大于或者等于 右边界 左移，l指向的是找的的结点，也可以是可插入结点，因为l左边都是小于l的
            } else {
                r = mid - 1;
            }

        }

        return l;
    }
}
