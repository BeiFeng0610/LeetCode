class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        // 把所有的数字都放到set中去重
        int longestStreak = 0;
        for (int num : num_set) {
            // 如果存在 num-1 的数，则有更长的连续序列，无需进入循环。
            if (!num_set.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;
                // 如果set中存在 num+1 的数则最大长度 +1
                while (num_set.contains(curNum + 1)) {
                    curNum += 1;
                    curStreak += 1;
                }
                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        return longestStreak;
    }
}
