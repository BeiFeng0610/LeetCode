class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] hash = new boolean[n];
        hash[start] = true;
        for (int i = 0; i < graph.length; ++i) {
            if (hash[graph[i][0]]) {
                hash[graph[i][1]] = true;
            }
        }
        for (int i = 0; i < graph.length; ++i) {
            if (hash[graph[i][0]]) {
                hash[graph[i][1]] = true;
            }
        }
        return hash[target];

    }
}

class Solution {
    // 访问状态数组
    private boolean[] visited = null;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 创建访问状态数组
        this.visited = new boolean[graph.length];
        // DFS
        return helper(graph, start, target);
    }

    private boolean helper(int[][] graph, int start, int target) {
        // 深度优先搜索
        for (int i = 0; i < graph.length; ++i) {
            // 确保当前路径未被访问（该判断主要是为了防止图中自环出现死循环的情况）
            if (!visited[i]) {
                // 若当前路径起点与终点相符，则直接返回结果
                if (graph[i][0] == start && graph[i][1] == target) {
                    return true;
                }
                // 设置访问标志
                visited[i] = true;
                // DFS关键代码，思路：同时逐渐压缩搜索区间
                if (graph[i][1] == target && helper(graph, start, graph[i][0])) {
                    return true;
                }
                // 清除访问标志
                visited[i] = false;
            }
        }
        return false;
    }

}