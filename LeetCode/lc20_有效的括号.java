package LeetCode;

import java.util.Stack;

class So{
    public boolean isValid(String s) {
        // 字符长度奇数直接返回false
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 左括号压栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } // 右括号不匹配，或者站内为空返回false
            else if (stack.isEmpty() || c == ')' && stack.peek() != '(' || c == ']' && stack.peek() != '[' || c == '}' && stack.peek() != '{') {
                return false;
            } else {
                // 弹出栈
                stack.pop();
            }
        }
        // 栈空返回true
        return stack.isEmpty();
    }
}
