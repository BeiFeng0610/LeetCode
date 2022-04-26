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
            if (!set.contains(chars[r])) {
                set.add(chars[r]);
            } else {
                max = Math.max(max, r - l);
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
