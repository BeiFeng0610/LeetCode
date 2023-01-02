class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // 把所有数放到集合中
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, 0);
        return res;
    }

    public void backtrack(int n, int first) {
        // 确定数字个数==n是，说明已经全部确定
        if (first == n) {
            // 把当前状态的集合加入
            res.add(new ArrayList<>(output));
        }
        // i 表示第几个数，依次把 1 2 ... n作为头，然后确定第二个，从集合中的第二个数开始，以此类推。
        for (int i = first; i < n; i++) {
            // first表示需要确定的位数，交换即可，可交换数的区间为[first,n]
            Collections.swap(output, first, i);
            backtrack(n, first + 1);
            // 交换回来，恢复原集合
            Collections.swap(output, first, i);
        }

    }
}

