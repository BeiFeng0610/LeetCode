class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        if (len < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int l = 0, r = 0, max = 0;
        for (r = 0; r < len; r++) {
            // set不包含则存入
            if (!set.contains(chars[r])) {
                set.add(chars[r]);
            } else {
                // 存在则记录最大长度
                max = Math.max(max, r - l);
                // 判断是那个字符重复，左边界收敛到重复的第一个字符，再右移一位，右边界即可继续右移
                while (chars[l] != chars[r]) {
                    set.remove(chars[l]);
                    l++;
                }
                l++;
            }
        }
        max = Math.max(max, r - l);
        return max;
    }
}
