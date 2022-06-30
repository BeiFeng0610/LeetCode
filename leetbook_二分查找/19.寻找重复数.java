import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0, r = len;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            // 快指针总会追上慢的，并值相等
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
