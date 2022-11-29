import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    boolean flag = true;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            list.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses && flag; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return flag;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (int j : list.get(i)) {
            if (visited[j] == 0) {
                dfs(j);
                if (!flag) {
                    return;
                }
            } else if (visited[j] == 1) {
                flag = false;
                return;
            }
        }
        visited[i] = 2;
    }
}