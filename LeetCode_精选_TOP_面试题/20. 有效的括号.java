import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (check(pop, ch)) {
                        continue;
                    }
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean check(char pop, char ch) {
        return pop == '(' && ch == ')'
                || pop == '[' && ch == ']'
                || pop == '{' && ch == '}';
    }
}

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}