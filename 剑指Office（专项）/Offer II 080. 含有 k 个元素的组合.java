class Solution {
    List<Integer> tmp;
    List<List<Integer>> res;
    int d;
    public List<List<Integer>> combine(int n, int k) {
        tmp = new ArrayList<>();
        res = new ArrayList<>();
        d = n;
        dfs(1, k);
        return res;
    }
    public void dfs(int n, int k) {
        if ((tmp.size() + (d - n + 1)) < k) {
            return;
        }
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(n);
        dfs(n + 1, k);
        tmp.remove(tmp.size() - 1);
        dfs(n + 1, k);
    }
    
}
