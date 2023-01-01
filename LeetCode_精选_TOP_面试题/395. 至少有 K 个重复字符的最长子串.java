import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char ch : counter.keySet()) {
            if (counter.get(ch) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(ch))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }
}