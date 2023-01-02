class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        // 下标越界就返回
        if (idx == candidates.length) {
            return;
        }
        // target == 0 表示满足
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // target减去当前层，然后判断，是否还有剩余
        if (target - candidates[idx] >= 0) {
            // 先加入本层
            combine.add(candidates[idx]);
            // 传入还需多大的数，  和当前下标，从当前层找到最底层，然后继续判断 if (target - candidates[idx] >= 0)
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            // 删除当前层
            combine.remove(combine.size() - 1);
        }

    }

    public static void main(String[] args) {
        new 剑指Offer.Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
