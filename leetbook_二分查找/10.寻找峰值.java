class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int l = 0, r = len - 1;
        // 模板三，因为 l + 1 < r,所以r至少为3，下面的mid-1不会越界
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            // 如果前一个数大于当前数，则范围在 【l,mid】
            if (nums[mid - 1] > nums[mid]) {
                r = mid;
                // 如果前一个数小于当前mid，则范围在 【mid,r】
            } else if (nums[mid - 1] < nums[mid]) {
                l = mid;
            }
        }

        return nums[l] < nums[r] ? r : l;
    }
}