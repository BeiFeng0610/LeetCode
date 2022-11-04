class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (1 <= a && a <= 9) {
                dp[i] = dp[i - 1];
            }
            if (10 <= b && b <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int prep = 0, pre = 1, cur = 0;
        for (int i = 1; i <= n; i++) {
            cur = 0;
            if (s.charAt(i - 1) != '0') {
                cur += pre;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                cur += prep;
            }
            prep = pre;
            pre = cur;
        }
        return cur;
    }
}

