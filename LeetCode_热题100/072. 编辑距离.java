class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        // 初始化dp边界
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        /**
         * 对于 word1 和 word2
         * 如果前 i 和前 j 个字符 末尾字符不同，则有三种情况，（i-1,j）+1，(i,j-1)+1, (i-1,j-1)+1 也就是 word1 添加一个或者 word2 添加一个，或者 两者任意修改一个
         * 如果末尾字符相同，则有三种情况，（i-1,j）+1，(i,j-1)+1, (i-1,j-1)
         */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i][j - 1] + 1;
                int down = dp[i - 1][j] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, leftDown));

            }
        }

        return dp[n][m];
    }
}