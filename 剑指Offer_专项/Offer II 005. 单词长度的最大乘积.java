class Solution {
    public int maxProduct(String[] words) {
        int wordLen = words.length;
        int[] ans = new int[wordLen];
        // 统计每个字母出现的位数，转换为二进制。最多出现第26位，不会越界
        for (int i = 0; i < wordLen; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                ans[i] |= 1 << word.charAt(j) - 'a';
            }
        }
        // 两数做 & 运算，如果有位数相同，则存在相同字母。
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
