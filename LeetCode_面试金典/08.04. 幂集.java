import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        backtrack(nums, i + 1);
        list.remove(list.size() - 1);
        backtrack(nums, i + 1);
    }
}