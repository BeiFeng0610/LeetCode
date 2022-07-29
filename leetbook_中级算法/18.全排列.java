import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    public void backtrack(int n, int idx) {
        if (idx == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = idx; i < n; i++) {
            Collections.swap(output, idx, i);
            backtrack(n, idx + 1);
            Collections.swap(output, idx, i);
        }
    }
}