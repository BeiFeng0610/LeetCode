import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> list = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        helper(n, n);
        return list;
    }

    private void helper(int l, int r) {
        if (l == 0 && r == 0) {
            list.add(sb.toString());
            return;
        }
        if (l > 0) {
            sb.append("(");
            helper(l - 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r > l) {
            sb.append(")");
            helper(l, r - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}