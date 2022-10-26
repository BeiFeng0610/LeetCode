import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) {
            list.add(num);
        }
        helper(nums, 0);
        return res;
    }

    private void helper(int[] nums, int idx) {
        if (nums.length == idx) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            Collections.swap(list, idx, i);
            helper(nums, idx + 1);
            Collections.swap(list, idx, i);
        }
    }
}