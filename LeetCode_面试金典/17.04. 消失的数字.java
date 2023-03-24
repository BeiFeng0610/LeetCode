import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}