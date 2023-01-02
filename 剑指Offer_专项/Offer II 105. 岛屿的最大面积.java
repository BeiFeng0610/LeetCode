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
            top = dfs(grid, i - 1, j);
        }
        if (i < grid.length - 1 && !tag[i + 1][j]) {
            bottom = dfs(grid, i + 1, j);
        }
        if (j > 0 && !tag[i][j-1]) {
            left = dfs(grid, i, j - 1);
        }
        if (j < grid[0].length-1 && !tag[i][j + 1]) {
            right = dfs(grid, i, j + 1);
        }
        return top + bottom + left + right + 1;
    }
}

// 精简版道理相同
class Solution {
    int max = 0, cur = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cur = 0;
                    dfs(grid, i, j);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
    public void dfs(int[][] grid, int i, int j) {
        // 判断越界
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        // 如果为1则累加，然后标记为0
        if (grid[i][j] == 1) {
            cur++;
            grid[i][j]=0;
        }
        // 深度遍历上下左右
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
