import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> strStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (Character.isAlphabetic(c)) {
                res.append(c);
            } else if (c == '[') {
                strStack.push(res);
                numStack.push(num);
                num = 0;
                res = new StringBuilder();
            } else {
                StringBuilder tmp = strStack.pop();
                int n = numStack.pop();
                for (int i = 0; i < n; i++) {
                    tmp.append(res);
                }
                res = tmp;
            }
        }
        return res.toString();
    }
}
