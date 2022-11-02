import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int idx) {
        if (nums.length == idx) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        backtrack(nums, idx + 1);
        tmp.add(nums[idx]);
        backtrack(nums, idx + 1);
        tmp.remove(tmp.size() - 1);
    }
}