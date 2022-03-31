class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int l = 0, r = 1, max = 1;
        while (r < len) {
            String tmp = s.substring(l, r);
            if (tmp.indexOf(s.charAt(r)) == -1) {
                r++;
                max = Math.max(max, r - l);
            } else {
                l = tmp.indexOf(s.charAt(r)) + 1 + l;
                r++;
            }
        }
        return len == 0 ? 0 : max;
    }
}
