import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            if (isNumber(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int r = stack.pop();
                int l = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(l + r);
                        break;
                    case "-":
                        stack.push(l - r);
                        break;
                    case "*":
                        stack.push(l * r);
                        break;
                    case "/":
                        stack.push(l / r);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}