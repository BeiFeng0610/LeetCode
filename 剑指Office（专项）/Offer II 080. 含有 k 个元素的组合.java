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
        // 提前剪枝，tmp中元素  加上后面所有的还是小于 k，就肯定不满足，直接返回
        if ((tmp.size() + (d - n + 1)) < k) {
            return;
        }
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // 添加当前层
        tmp.add(n);
        // 进入下一层
        dfs(n + 1, k);
        // 删除当前层
        tmp.remove(tmp.size() - 1);
        // 继续下一层
        dfs(n + 1, k);
    }
    
}
