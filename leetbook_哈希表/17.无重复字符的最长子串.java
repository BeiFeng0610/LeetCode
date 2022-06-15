package leetbook_哈希表;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int len = s.length();
        int l = 0, r = l;
        // 滑动窗口 保持窗口中没有重复的元素即可
        while (r < len) {
            char c = s.charAt(r);
            if (!set.contains(c)) {
                set.add(c);
                r++;
            } else {
                while (s.charAt(l) != c) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
                r++;
            }
            max = Math.max(max, set.size());
        }

        return max;
    }
}

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            // 把开始位置和，上一次出现位置比较
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            // 更新最后一次出现的位置
            last[index] = i;
        }

        return res;
    }
}