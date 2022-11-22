import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums,(v1,v2)->{
            long wei1=10,wei2=10;
            while (wei1 <= v1) {
                wei1 *= 10;
            }
            while (wei2 <= v2) {
                wei2 *= 10;
            }
            return (int) ((wei1 * v2 + v1) - (wei2 * v1 + v2));
        });
        if (newNums[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : newNums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
