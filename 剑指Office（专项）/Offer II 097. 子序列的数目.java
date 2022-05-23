class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        // 如果 t 是n下标开始就是空串，有且仅有一个子序列
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        // s从后往前依次匹配t串
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                // 字符相等，有两种情况，考虑t[j+1:]作为s[i+1:]的子序列，和不相等的情况。
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    // 不相等，只考虑t[j:]作为s[i+1:]的子序列
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
