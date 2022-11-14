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

class Solution {
    private List<String> res = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        backTracking(s, wordDict, 0);
        return res;
    }

    private void backTracking(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            res.add(String.join(" ", list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordDict.contains(s.substring(start, i + 1))) {
                list.add(s.substring(start, i + 1));
                backTracking(s, wordDict, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
