class Solution {
    List<List<Integer>> ret;
    List<Integer> list;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ret = new ArrayList<>();
        list = new ArrayList<>();
        dfs(graph, 0);
        return ret;
    }

    public void dfs(int[][] graph, int n) {
        list.add(n);
        if (n == graph.length - 1) {
            ret.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int i = 0; i < graph[n].length; i++) {
            dfs(graph, graph[n][i]);
        }
        list.remove(list.size() - 1);
    }
}
