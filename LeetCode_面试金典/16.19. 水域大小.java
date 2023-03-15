import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int m;
    int n;
    private List<Integer> list = new ArrayList<>();

    public int[] pondSizes(int[][] land) {
        m = land.length;
        n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    int count = dfs(land, i, j);
                    list.add(count);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = 1;
        int count = 1;
        count += dfs(land, i - 1, j - 1);
        count += dfs(land, i - 1, j);
        count += dfs(land, i - 1, j + 1);
        count += dfs(land, i, j - 1);
        count += dfs(land, i, j + 1);
        count += dfs(land, i + 1, j - 1);
        count += dfs(land, i + 1, j);
        count += dfs(land, i + 1, j + 1);
        return count;
    }
}