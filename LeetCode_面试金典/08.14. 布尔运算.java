import java.util.Arrays;

class Solution {
    private char[] arr;
    private int[][][] dp;
    public int countEval(String s, int result) {
        arr = s.toCharArray();
        int len = s.length();
        dp = new int[len][len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return rec(0, len - 1, result);
    }

    private int rec(int start, int end, int result) {
        if (start == end) {
            return arr[start] - '0' == result ? 1 : 0;
        }
        if (dp[start][end][result] != -1) {
            return dp[start][end][result];
        }
        int ansCount = 0;
        for (int k = start; k < end; k+=2) {
            char operator = arr[k + 1];
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (getBoolAns(i, j, operator) == result) {
                        ansCount += rec(start, k, i) * rec(k + 2, end, j);
                    }
                }
            }
        }
        dp[start][end][result] = ansCount;
        return ansCount;
    }

    private int getBoolAns(int i, int j, char operator) {
        switch (operator) {
            case '&':
                return i & j;
            case '|':
                return i | j;
            default:
                return i ^ j;
        }
    }
}