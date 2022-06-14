/*
*   后缀转中缀表达式
*       遇到操作数压入栈
*       遇到运算符弹出两个操作数(注意左右顺序)，计算完成后再压入栈中。
* */
public int evalRPN(String[] tokens) {
    int len = tokens.length;
    Deque<Integer> stack = new LinkedList<Integer>();
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
