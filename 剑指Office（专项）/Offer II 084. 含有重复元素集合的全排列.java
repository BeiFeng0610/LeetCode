class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.sort(nums);

        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            output.add(nums[i]);
            vis[i] = true;
            backtrack(nums, idx + 1);
            vis[i] = false;
            output.remove(idx);
        }

    }
}
