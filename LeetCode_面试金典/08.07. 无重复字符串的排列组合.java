import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        backtrack(s.toCharArray(), 0);
        return list.toArray(new String[0]);
    }

    private void backtrack(char[] s, int idx) {
        if (idx == s.length) {
            list.add(new String(s));
            return;
        }
        for (int i = idx; i < s.length; i++) {
            swap(s, i, idx);
            backtrack(s, idx + 1);
            swap(s, i, idx);
        }
    }

    private void swap(char[] s, int i, int idx) {
        char ch = s[i];
        s[i] = s[idx];
        s[idx] = ch;
    }
}