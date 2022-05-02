class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length < 2) {
            return true;
        }

        int[] or = new int[26];
        int o = 0;// 序号
        // 记录字母表中每一个字母的序号, 第一个先出现的序号为0，然后依次累加。
        for(char c: order.toCharArray()) {
            or[c-'a'] += ++o;
        }
        // 前一个字符串
        char[] pre = words[0].toCharArray();
        int preLen = pre.length, curLen = 0;
        for (int i = 1; i < words.length; i++) {
            // 当前字符串
            char[] cur = words[i].toCharArray();
            curLen = cur.length;
            int len = Math.min(preLen, curLen);
            int j = 0;
            // 略过相同的字母
            while (j < len && cur[j] == pre[j]) {
                j++;
            }
            // 如果前一个字符串的权重大于当前，则返回false
            if (j < len && or[cur[j] - 'a'] < or[pre[j] - 'a']) {
                return false;
            }
            // 如果前一个字符串长度大于当前，且前面部分相同，则返回false
            if (j == len && preLen > curLen) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}
