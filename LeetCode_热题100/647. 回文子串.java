class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if (len < 2) {
            return 1;
        }

        boolean[][] dp = new boolean[len][len];
        int count = 0;
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            count++;
        }
        char[] chars = s.toCharArray();
        for (int i = 1; i < len; i++) {
            if (chars[i - 1] == chars[i]) {
                dp[i - 1][i] = true;
                count++;
            }
        }
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                int sIdx = j;
                int eIdx = j + i - 1;
                if (chars[sIdx] == chars[eIdx] && dp[sIdx + 1][eIdx - 1]) {
                    dp[sIdx][eIdx] = true;
                    count++;
                }
            }
        }
        return count;
    }
}

class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
