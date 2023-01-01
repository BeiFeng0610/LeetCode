class Solution {
    public int firstUniqChar(String s) {
        int[] bitChar = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            int idx = ch - 'a';
            bitChar[idx]++;
        }
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (bitChar[idx] == 1) {
                return i;
            }
        }
        return -1;
    }
}