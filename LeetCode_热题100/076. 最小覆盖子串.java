import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> ans = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }

        int sLen = s.length();
        int ansL = -1, ansR = -1;
        int l = 0, r = -1, len = Integer.MAX_VALUE;
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                ans.put(s.charAt(r), ans.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    ans.put(s.charAt(l), ans.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);

    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (ans.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
