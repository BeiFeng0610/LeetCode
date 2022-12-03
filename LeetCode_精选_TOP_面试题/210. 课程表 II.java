import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] visited;
    int[] res;
    boolean flag = true;
    int idx = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[0]).add(prerequisite[1]);
        }
        visited = new int[numCourses];
        res = new int[numCourses];

        for (int i = 0; i < list.size(); i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
            if (!flag) {
                return new int[0];
            }
        }
        return res;
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
        res[idx++] = i;
        visited[i] = 2;
    }

}