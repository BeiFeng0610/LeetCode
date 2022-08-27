import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return res;
    }

    public void backtrack(int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        if (left == right) {
            backtrack(left - 1, right, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (left > 0) {
                backtrack(left - 1, right, sb.append('('));
                sb.deleteCharAt(sb.length() - 1);
            }
            backtrack(left, right - 1, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}