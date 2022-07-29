import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis(new StringBuilder(), n, n);
        return res;
    }

    private void getParenthesis(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left == right) {
            getParenthesis(sb.append("("), left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis(sb.append("("), left - 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            getParenthesis(sb.append(")"), left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        }
        Set<String> hs = new HashSet<>();
        for (String s : generateParenthesis(n - 1)) {
            for (int i = 0; i < 2 * n - 2; i++) {
                hs.add(s.substring(0, i) + "()" + s.substring(i, s.length()));
            }
        }
        return new ArrayList(hs);
    }
}