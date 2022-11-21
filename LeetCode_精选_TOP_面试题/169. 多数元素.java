import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}


class Solution {
    public int majorityElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += (res == num) ? 1 : -1;
        }
        return res;
    }
}
