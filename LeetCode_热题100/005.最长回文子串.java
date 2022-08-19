class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        for (int i = 2; i <= len; i++) {
            for (int L = 0; L < len; L++) {
                int R = L + i - 1;
                if (R >= len) {
                    break;
                }
                if (chars[L] != chars[R]) {
                    dp[L][R] = false;
                } else {
                    if (R - L < 3) {
                        dp[L][R] = true;
                    } else {
                        dp[L][R] = dp[L + 1][R - 1];
                    }
                }

                if (dp[L][R] && R - L + 1 > maxLen) {
                    maxLen = R - L + 1;
                    begin = L;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}