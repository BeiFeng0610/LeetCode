class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 初始化数组，表示已经确定的位数。
        vis = new boolean[nums.length];
        // 排序数组，把相同的数放在一起
        Arrays.sort(nums);

        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int idx) {
        // idx表示已经确定多少位数
        if (idx == nums.length) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数组下标上的数字已经加入集合中，就跳过。
            // 或者 当前数和前一个数相同，且前一个数没有添加，说明当前的这个数也不用添加
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            // 添加到集合中，vis标记为true
            output.add(nums[i]);
            vis[i] = true;
            backtrack(nums, idx + 1);
            // 恢复集合，恢复vis状态
            vis[i] = false;
            output.remove(idx);
        }

    }
}
