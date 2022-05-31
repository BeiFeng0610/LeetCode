class Solution {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret = Math.max(ret, dfs(matrix, i, j, memo));
            }
        }
        return ret;
    }
    public int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        ++memo[i][j];
        for (int[] dir : dirs) {
            int newM = i + dir[0], newN = j + dir[1];
            if (newM >= 0 && newM < m && newN >= 0 && newN < n && matrix[newM][newN] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, newM, newN, memo) + 1);               
            }
        }
        return memo[i][j];
    }
}
