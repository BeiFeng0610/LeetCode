import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (sLen < pLen) {
            return res;
        }

        char[] chars = p.toCharArray();
        Set<Character> chSet = new HashSet<>();
        for (char ch : chars) {
            chSet.add(ch);
        }

        Arrays.sort(chars);
        String pStr = new String(chars);

        for (int i = 0; i <= sLen - pLen; i++) {
            char ch = s.charAt(i);
            if (chSet.contains(ch)) {
                char[] tmp = s.substring(i, i + pLen).toCharArray();
                Arrays.sort(tmp);
                String sStr = new String(tmp);
                if (pStr.equals(sStr)) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (sLen < pLen) {
            return res;
        }

        int[] pTag = new int[26];
        int[] sTag = new int[26];
        for (int i = 0; i < pLen; i++) {
            pTag[p.charAt(i) - 'a']++;
            sTag[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pTag, sTag)) {
            res.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            sTag[s.charAt(i-pLen) - 'a']--;
            sTag[s.charAt(i) - 'a']++;
            if (Arrays.equals(pTag, sTag)) {
                res.add(i - pLen + 1);
            }
        }
        return res;
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
