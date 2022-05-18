class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, 0);
        return res;
    }

    public void backtrack(int n, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, first + 1);
            Collections.swap(output, first, i);
        }

    }
}

