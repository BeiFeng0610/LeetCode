import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<List<Integer>> list = new ArrayList<>();
    private int r;
    private int c;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return res;
        }
        list.add(new ArrayList<>(List.of(0, 0)));
        dfs(obstacleGrid, 0, 0);
        return res;
    }

    public void dfs(int[][] obstacleGrid, int i, int j) {
        if (res.size() != 0 || i == r || j == c || obstacleGrid[i][j] == 1) {
            return;
        }
        if (i == r - 1 && j == c - 1) {
            res = new ArrayList<>(list);
            return;
        }
        list.add(Arrays.asList(i + 1, j));
        dfs(obstacleGrid, i + 1, j);
        list.remove(list.size() - 1);

        list.add(Arrays.asList(i, j + 1));
        dfs(obstacleGrid, i, j + 1);
        list.remove(list.size() - 1);
        obstacleGrid[i][j] = 1;
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int r;
    private int c;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return res;
        }
        dfs(obstacleGrid, 0, 0);
        return res;
    }

    public boolean dfs(int[][] obstacleGrid, int i, int j) {
        if (i == r || j == c || obstacleGrid[i][j] == 1) {
            return false;
        }
        res.add(Arrays.asList(i, j));
        if (i == r - 1 && j == c - 1) {
            return true;
        }
        if (dfs(obstacleGrid, i + 1, j) || dfs(obstacleGrid, i, j + 1)) {
            return true;
        }
        res.remove(res.size() - 1);
        obstacleGrid[i][j] = 1;
        return false;
    }
}