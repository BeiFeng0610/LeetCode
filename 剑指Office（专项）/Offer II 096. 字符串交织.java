class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        
        if (n + m != t) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m ; j++) {
                // 找到上一个匹配的s3字符下标
                int p = i + j - 1;
                if (i > 0) {
                    // 前一个字符匹配并且当前也匹配才能true
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    // f(i,j)表示s1的前i个元素和s2的前j个元素是否能交织组成s3的前i+j个元素
                    // 即此时f(i,j)取决于 f(i−1,j)，在此情况下如果 f(i−1,j)为真，则 f(i,j)也为真。
                    // 同样的，如果 s2 的第 j 个元素和 s3的第i+j个元素相等并且 f(i,j−1)为真，则 f(i,j)也为真
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return dp[n][m];
    }
}
