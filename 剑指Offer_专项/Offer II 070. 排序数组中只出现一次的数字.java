class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            // 下标单双必须相等，[mid ^ 1]下标为单则找到上一个，为双则找到下一个。如果相等，则收缩范围 mid+1 -- r
            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return nums[l];
    }
}
class Solution2 {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            // 和上面差不多，奇数就减1，偶数不变，让mid保持偶数位
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
