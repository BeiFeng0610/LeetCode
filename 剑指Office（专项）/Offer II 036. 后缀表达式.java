class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        // 后缀表达式，总是有效的，则省去许多判断，直接判断运算符即可，弹出的第一个为右操作数，第二个为左操作数。
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
}

class Solution2 {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        // 用数组代替栈，后缀表达式总是有效，则运算符一定比操作数少1个，则操作数最多为 n+1/2
        int[] stack = new int[(n + 1) / 2];
        // 表示当前为栈空
        int index = -1;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    // 因为需要两个操作数，完成后需要变成一个数，下移一位，刚好指向左操作数，取出数完成对应操作。
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
                    // 栈帧上移，指向栈顶
                    index++;
                    // 插入栈顶元素
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
