import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> combination = new ArrayList<>();
    List<Integer> com = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0);
        return combination;
    }

    public void backtrack(int[] candidates, int target, int candidate, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (candidate >= target) {
            if (candidate == target) {
                combination.add(new ArrayList<>(com));
            }
            return;
        }
        for (; idx < candidates.length; idx++) {
            com.add(candidates[idx]);
            backtrack(candidates, target, candidate + candidates[idx], idx);
            com.remove(com.size() - 1);
        }
    }
}

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> combine = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], idx);
            combine.remove(combine.size() - 1);
        }
    }
}