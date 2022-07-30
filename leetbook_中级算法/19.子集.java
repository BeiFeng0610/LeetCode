import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> output = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int idx) {
        ans.add(new ArrayList<>(output));
        for (int i = idx; i < nums.length; i++) {
            output.add(nums[i]);
            backtrack(nums, i + 1);
            output.remove(output.size() - 1);
        }
    }
}
class Solution {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}

