import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int r = stack.pop();
                int l = stack.pop();
                switch (token) {
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

    private boolean isNumber(String str) {
        return !"+".equals(str) && !"-".equals(str) && !"*".equals(str) && !"/".equals(str);
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        int[] stack = new int[(len + 1) / 2];
        int idx = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    idx--;
                    stack[idx - 1] += stack[idx];
                    break;
                case "-":
                    idx--;
                    stack[idx - 1] -= stack[idx];
                    break;
                case "*":
                    idx--;
                    stack[idx - 1] *= stack[idx];
                    break;
                case "/":
                    idx--;
                    stack[idx - 1] /= stack[idx];
                    break;
                default:
                    stack[idx++] = Integer.parseInt(token);
            }
        }
        return stack[0];
    }
}

