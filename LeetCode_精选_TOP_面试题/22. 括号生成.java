import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        helper(n, n);
        return res;
    }

    private void helper(int left, int right) {
        if (left + right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            helper(left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(")");
            helper(left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}