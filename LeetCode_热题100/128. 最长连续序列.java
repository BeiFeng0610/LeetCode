import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int len = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curLen = 1;
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                len = Math.max(len, curLen);
            }
        }
        return len;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int len = 0;
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
                len = Math.max(len, rightNum - leftNum + 1);
            }
        }
        return len;
    }
}