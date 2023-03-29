class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int word1Idx = words.length, word2Idx = words.length;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Idx = i;
                res = Math.min(res, Math.abs(word1Idx - word2Idx));
            } else if (words[i].equals(word2)) {
                word2Idx = i;
                res = Math.min(res, Math.abs(word1Idx - word2Idx));
            } else if (res == 1) {
                return res;
            }
        }
        return res;
    }
}
