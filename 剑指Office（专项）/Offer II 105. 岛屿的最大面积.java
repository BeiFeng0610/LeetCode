class Solution {
    boolean[][] tag;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        tag = new boolean[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int tmp = dfs(grid, i, j);
                    max = Math.max(max, tmp);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || grid[i][j] == 0) {
            return 0;
        }
        tag[i][j] = true;
        int top = 0, bottom = 0, left = 0, right = 0;
        if (i > 0 && !tag[i - 1][j]) {
            tag[i - 1][j] = true;
            top = dfs(grid, i - 1, j);
        }
        if (i < grid.length - 1 && !tag[i + 1][j]) {
            tag[i + 1][j] = true;
            bottom = dfs(grid, i + 1, j);
        }
        if (j > 0 && !tag[i][j-1]) {
            tag[i][j - 1] = true;
            left = dfs(grid, i, j - 1);
        }
        if (j < grid[0].length-1 && !tag[i][j + 1]) {
            tag[i][j + 1] = true;
            right = dfs(grid, i, j + 1);
        }
        return top + bottom + left + right + 1;
    }
}
