// 纯暴力法
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        char[] chars = s2.toCharArray();
        int low = 0, high = 0;
        boolean tag = true;
        while (low < s2.length()) {
            if (map.containsKey(chars[low])) {
                while (high < chars.length && map.containsKey(chars[high]) && map.get(chars[high]) > 0) {
                    char c = chars[high];
                    map.put(c, map.get(c) - 1);
                    high++;
                }
                for (Map.Entry<Character, Integer> set : map.entrySet()) {
                    if (set.getValue() != 0) {
                        tag = false;
                    }
                }
                if (tag) {
                    return tag;
                }
                map.put(chars[low], map.get(chars[low]) + 1);
            }
            low++;
            if (low > high) {
                high = low;
            }
            tag = true;
        }
        return false;
    }

    public static void main(String[] args) {
        new 剑指Office.Solution().checkInclusion("abc", "cccccbabbbaaaa");
    }
}
class Solution3 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        // 字母只有26位
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        // 统计两字符串，生成数组，每位的数对应字母个数。
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        // 比较数组，元素个数相同则匹配到了
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        // cnt1是固定的，匹配不到就循环让cnt2滑动。
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

}

class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        // 记录cnt1的数量
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        // 双指针匹配，匹配到存在字符则+1，匹配多了或者不匹配，数组位会大于1，左边界收敛，数组相应位数-1，知道所有位数小于等于0.
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            // 判断匹配长度是否相等，上述条件满足，则一定匹配成功。
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
