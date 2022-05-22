class Solution {
    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        // 从后往前把不是回文的全部更新。
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        int[] f = new int[len];
        // 初始化次数为最大
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < len; ++i) {
            // 第0开始肯定不用分割，必是回文
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                // 判断从 [0,i)
                for (int j = 0; j < i; ++j) {
                    // 如果找到回文，就判断最小分割次数
                    if (dp[j + 1][i]) {
                        // 判断分割点前后最小分割次数
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[len-1];
    }
}
