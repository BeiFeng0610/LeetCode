class Solution {
    boolean[][] visited;
    int m;
    int n;
    int k;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int ci, int cj) {
        if (i >= m || j >= n || k < ci + cj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? ci + 1 : ci - 8, cj) + dfs(i, j + 1, ci, (j + 1) % 10 != 0 ? cj + 1 : cj - 8);
    }
}