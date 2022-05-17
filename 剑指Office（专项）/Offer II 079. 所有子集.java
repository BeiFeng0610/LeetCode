class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // 根据数组长度，定义一个宽度为n的二进制数 比如n=3 二进制位111
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> tmp = new ArrayList<>();
            // 所有子集即为：001 010 011 100 101 110 111 刚好符合二进制
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
class Solution2 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            // 到尾部就添加
            ans.add(new ArrayList<>(t));
            return;
        }
        // 全部添加，直到加满
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        // 删除集合最后一个结点，也就是删除当前层，找下面的层
        t.remove(t.size() - 1);
        // 继续添加
        dfs(cur + 1, nums);
    }
}
