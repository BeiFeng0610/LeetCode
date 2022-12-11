import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] bitChar1 = new int[26];
        int[] bitChar2 = new int[26];
        char[] sChars = s.toCharArray();
        for (char ch : sChars) {
            int idx = ch - 'a';
            bitChar1[idx]++;
        }
        char[] tChars = t.toCharArray();
        for (char ch : tChars) {
            int idx = ch - 'a';
            bitChar2[idx]++;
        }
        return Arrays.equals(bitChar1, bitChar2);
    }
}