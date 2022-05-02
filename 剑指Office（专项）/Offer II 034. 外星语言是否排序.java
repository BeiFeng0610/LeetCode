class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length < 2) {
            return true;
        }

        int[] or = new int[26];
        int o = 0;
        // 记录字母表中每一个字母的序号
        for(char c: order.toCharArray()) {
            or[c-'a'] += ++o;
        }

        char[] pre = words[0].toCharArray();
        int preLen = pre.length, curLen = 0;
        for (int i = 1; i < words.length; i++) {
            char[] cur = words[i].toCharArray();
            curLen = cur.length;
            int len = Math.min(preLen, curLen);
            int j = 0;
            while (j < len && cur[j] == pre[j]) {
                j++;
            }

            if (j < len && or[cur[j] - 'a'] < or[pre[j] - 'a']) {
                return false;
            }

            if (j == len && preLen > curLen) {
                return false;
            }

            pre = cur;
        }

        return true;
    }
}
