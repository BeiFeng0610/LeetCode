import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }
        char[] chars = s.toCharArray();
        dfs(chars, 0, len);
        return res;
    }

    private void dfs(char[] chars, int idx, int len) {
        if (idx == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < len; i++) {
            if (!checkPalindrome(chars, idx, i)) {
                continue;
            }
            list.add(new String(chars, idx, i - idx + 1));
            dfs(chars, i + 1, len);
            list.remove(list.size() - 1);
        }
    }

    private boolean checkPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


public class Solution {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }

        char[] charArray = s.toCharArray();
        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        dfs(s, 0, len, dp);
        return res;
    }

    private void dfs(String s, int index, int len, boolean[][] dp) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (dp[index][i]) {
                path.add(s.substring(index, i + 1));
                dfs(s, i + 1, len, dp);
                path.remove(path.size() - 1);
            }
        }
    }
}
