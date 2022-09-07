import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> an = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(an));
            return;
        }
        an.add(nums[idx]);
        backtrack(nums, idx + 1);
        an.remove(an.size() - 1);
        backtrack(nums, idx + 1);
    }
}

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