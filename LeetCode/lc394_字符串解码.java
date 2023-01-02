package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/*
*   数字栈和字母栈
*       碰到字母拼接字母
*       碰到数字计算数字
*       碰到'['把数字压入栈中，
*           压入"数字["前面拼接到的一串字符
*       碰到']'
*           弹出一个数字，把当前拼接好的字符拼到上一串字符
* */
class Solution {
    public String decodeString(String s) {
        Deque<Integer> nStack = new LinkedList<>();
        Deque<StringBuilder> cStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int num = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                cStack.push(sb);
                nStack.push(num);
                sb = new StringBuilder();
                num = 0;
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                StringBuilder temp = cStack.pop();
                int n = nStack.pop();
                for (int i = 0; i < n; i++) {
                    temp.append(sb);
                }
                sb = temp;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        剑指Offer.Solution s = new 剑指Offer.Solution();
        System.out.println(s.decodeString("3[a2[bc]]"));
    }
}
