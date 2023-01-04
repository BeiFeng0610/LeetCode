import java.util.Arrays;

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] sch1 = s1.toCharArray();
        char[] sch2 = s2.toCharArray();
        Arrays.sort(sch1);
        Arrays.sort(sch2);
        return Arrays.equals(sch1, sch2);
    }
}

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] sch1 = s1.toCharArray();
        int[] bit1 = new int[26];
        for (char ch : sch1) {
            bit1[ch - 'a']++;
        }
        char[] sch2 = s2.toCharArray();
        int[] bit2 = new int[26];
        for (char ch : sch2) {
            bit2[ch - 'a']++;
        }
        return Arrays.equals(bit1, bit2);
    }
}

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] cuts = new int[256];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (++cuts[s1.charAt(i)] == 1) {
                count++;
            }
            if (--cuts[s2.charAt(i)] == 0) {
                count--;
            }
        }
        return count == 0;
    }
}








