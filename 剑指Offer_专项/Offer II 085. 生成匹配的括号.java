class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    public void generateAll(char[] curr, int pos, List<String> result) {
        // 如果长度满足，就判断是否有效
        if (pos == curr.length) {
            if (valid(curr)) {
                result.add(new String(curr));
            }
        } else {
            // 枚举出全部情况然后判断
            curr[pos] = '(';
            generateAll(curr, pos + 1, result);
            curr[pos] = ')';
            generateAll(curr, pos + 1, result);
        }
    }

    // balance==0才有效
    public boolean valid(char[] curr) {
        int balance = 0;
        for (char c : curr) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}

class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int left, int right, int max) {
        // 长度满足就添加返回
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        // 左括号小于n就可以添加
        if (left < max) {
            cur.append('(');
            backtrack(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        // 右括号小于左括号也可以添加
        if (right < left) {
            cur.append(")");
            backtrack(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
