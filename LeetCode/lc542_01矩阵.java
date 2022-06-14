package LeetCode;

class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ret = new int[m][n];
        boolean[][] flag = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    flag[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int k = 0; k < 4; k++) {
                int mi = i + dirs[k][0];
                int mj = j + dirs[k][1];
                if (mi >= 0 && mi < m && mj >= 0 && mj < n && !flag[mi][mj]) {
                    ret[mi][mj] = ret[i][j] + 1;
                    queue.offer(new int[]{mi, mj});
                    flag[mi][mj] = true;
                }
            }
        }

        return ret;
    }
}
