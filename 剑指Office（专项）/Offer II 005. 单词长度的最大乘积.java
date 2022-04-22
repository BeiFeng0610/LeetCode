class Solution {
    public int maxProduct(String[] words) {
        int wordLen = words.length;
        int[] ans = new int[wordLen];
        for (int i = 0; i < wordLen; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                ans[i] |= 1 << word.charAt(j) - 'a';
            }
        }
        int max = 0;
        for (int i = 0; i < wordLen; i++) {
            for (int j = i + 1; j < wordLen; j++) {
                if ((ans[i] & ans[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
