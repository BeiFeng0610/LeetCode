class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen || s.equals(t)) {
            return false;
        }
        int[] ant1 = new int[26];
        int[] ant2 = new int[26];
        for (int i = 0; i < slen; i++) {
            ++ant1[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < tlen; i++) {
            ++ant2[t.charAt(i) - 'a'];
        }
        return Arrays.equals(ant1, ant2);
    }
}


class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}


class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
