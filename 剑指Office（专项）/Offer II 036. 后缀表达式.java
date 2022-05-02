class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int r = stack.pop();
                int l = stack.pop();
                switch (tokens[i]) {
                    case "+" -> stack.push(l + r);
                    case "-" -> stack.push(l - r);
                    case "*" -> stack.push(l * r);
                    case "/" -> stack.push(l / r);
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"});
    }
}

class Solution2 {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
