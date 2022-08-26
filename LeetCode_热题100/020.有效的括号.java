import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                Character t = stack.poll();
                if (t == null || ch == ')' && t != '(' || ch == '}' && t != '{' || ch == ']' && t != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}