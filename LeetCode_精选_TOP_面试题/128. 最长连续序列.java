import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int num : nums) {
            if (set.contains(num)) {
                int tmp = num;
                int count = 1;
                while (set.contains(tmp--)) {
                    set.remove(tmp);
                    count++;
                }
                tmp = num;
                while (set.contains(tmp++)) {
                    set.remove(tmp);
                    count++;
                }
                set.remove(num);
                max = Math.max(max, count);
            }
        }
        return max;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int leftNum = num;
                while (set.remove(leftNum - 1)) {
                    leftNum--;
                }
                int rightNum = num;
                while (set.remove(rightNum + 1)) {
                    rightNum++;
                }
                max = Math.max(max, rightNum - leftNum + 1);
            }
        }
        return max;
    }
}