import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char opt = '+';
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == chars.length - 1) {
                switch (opt) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                opt = ch;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}