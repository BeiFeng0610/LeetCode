class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    List<int[]> freq = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }

        }
        dfs(target, 0);
        return ans;
    }

    public void dfs(int target, int idx) {
        // target == 0 表示满足
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 下标越界就返回
        if (idx == freq.size() || freq.get(idx)[0] > target) {
            return;
        }
        // 直接跳过
        dfs(target,idx + 1);
        // target减去当前层，然后判断，是否还有剩余
        int most = Math.min(target / freq.get(idx)[0], freq.get(idx)[1]);
        for (int i = 1; i <= most ; ++i) {
            combine.add(freq.get(idx)[0]);
            dfs(target - i * freq.get(idx)[0], idx + 1);
        }
        for (int i = 1; i <= most ; i++) {
            combine.remove(combine.size() - 1);
        }

    }
}
