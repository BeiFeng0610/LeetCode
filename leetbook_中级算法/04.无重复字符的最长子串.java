import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int ret = 0, l = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            } else {
                int pre = l;
                l = map.get(chars[i]) + 1;
                for (int j = pre; j < l; j++) {
                    map.remove(chars[j]);
                }
                map.put(chars[i], i);
            }
            ret = Math.max(ret, i - l + 1);
        }
        return ret;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, ret = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
            } else {
                while (chars[l] != chars[i]) {
                    set.remove(chars[l++]);
                }
                l++;
            }
            ret = Math.max(ret, set.size());
        }
        return ret;
    }
}










