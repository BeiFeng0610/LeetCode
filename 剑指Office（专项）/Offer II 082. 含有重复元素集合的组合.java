class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    List<int[]> freq = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        // 排序，把相同的数放到一起
        Arrays.sort(candidates);
        // 统计每个数的个数
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
        // 下标越界就返回，freq.get(idx)[0] > target表示后面的数肯定不满足（因为排序了）
        if (idx == freq.size() || freq.get(idx)[0] > target) {
            return;
        }
        // 直接跳过
        dfs(target,idx + 1);
        // freq.get(idx)[1] 当前数 的个数，  如果 target = 2 ，但是有3个1，所以最多能取两个，三个会出现重复项
        int most = Math.min(target / freq.get(idx)[0], freq.get(idx)[1]);
        // 先加入一个，可能有多个
        for (int i = 1; i <= most ; ++i) {
            combine.add(freq.get(idx)[0]);
            // 可能有多个，所以target - i * freq.get(idx)[0]
            dfs(target - i * freq.get(idx)[0], idx + 1);
        }
        for (int i = 1; i <= most ; i++) {
            // 删除当前层，返回
            combine.remove(combine.size() - 1);
        }

    }
}
