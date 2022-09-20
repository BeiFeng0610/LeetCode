import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer maj = null;
        for (int num : nums) {
            if (count == 0) {
                maj = num;
            }
            count += (num == maj) ? 1 : -1;
        }
        return maj;
    }
}