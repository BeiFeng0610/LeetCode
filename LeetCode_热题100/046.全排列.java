import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> output = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) {
            output.add(num);
        }
        backtrack(output, 0);
        return ans;
    }

    public void backtrack(List<Integer> output, int idx) {
        if (idx == output.size()) {
            ans.add(new ArrayList<>(output));
            return;
        }
        for (int i = idx; i < output.size(); i++) {
            Collections.swap(output, idx, i);
            backtrack(output, idx + 1);
            Collections.swap(output, idx, i);
        }
    }
}