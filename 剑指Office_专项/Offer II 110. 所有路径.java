class Solution {
    List<List<Integer>> ret;
    List<Integer> list;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ret = new ArrayList<>();
        list = new ArrayList<>();
        dfs(graph, 0);
        return ret;
    }

    // 传入图，以及当前所在结点
    public void dfs(int[][] graph, int n) {
        list.add(n);
        // 结点满足 n-1 则返回
        if (n == graph.length - 1) {
            ret.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        // 遍历每层结点相邻的结点。
        for (int i = 0; i < graph[n].length; i++) {
            dfs(graph, graph[n][i]);
        }
        list.remove(list.size() - 1);
    }
}
