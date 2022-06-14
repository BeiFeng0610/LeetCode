package LeetCode;

class Solution {

    /*
    * 完全平方数（动态规划）
    *       1 1 ,2 2 ,3 3, 4 1
    *       5 = ans[5-1] + 1, ans[5-4] + 1 取最小
    *       6 = ans[6-1] + 1, ans[6-4] + 1
    *       8 = ans[8-1] + 1, ans[8-4] + 1
    * */

    public int numSquares(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, ans[i - j * j]);
            }
            ans[i] = min + 1;
        }
        return ans[n];
    }
}
