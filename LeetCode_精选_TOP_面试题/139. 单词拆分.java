import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        for (String word : wordDict) {
            set.add(word);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] res = new boolean[n + 1];
        res[0] = true;
        for (int r = 1; r < n + 1; r++) {
            for (int l = r - 1; l >= 0; l--) {
                if (wordDict.contains(s.substring(l, r)) && res[l]) {
                    res[r] = true;
                    break;
                }
            }
        }
        return res[n];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //读题，s就是背包，wordDict就是物品
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //因为可以重复，且对于顺序有要求（排序），所以背包在外
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int wlen = wordDict.get(j).length();
                if (wlen <= i) {
                    if (dp[i - wlen] && wordDict.get(j).equals(s.substring(i - wlen, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}