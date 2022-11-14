import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<String> set;
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        int len = s.length();
        toFlashBack(s, 0, len);
        return res;
    }

    private void toFlashBack(String s, int idx, int len) {
        if (idx == len) {
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        StringBuilder tmp = new StringBuilder();
        int size = sb.length();
        for (int i = idx; i < len; i++) {
            tmp.append(s.charAt(i));
            if (set.contains(tmp.toString())) {
                sb.append(tmp).append(" ");
                toFlashBack(s, i + 1, len);
                sb.delete(size, sb.length());
            }
        }

    }
}
