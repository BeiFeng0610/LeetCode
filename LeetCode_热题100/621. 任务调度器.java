import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 记录字母出现次数
        int[] letter = new int[26];
        for (char task : tasks) {
            letter[task - 'A']++;
        }
        // 排序
        Arrays.sort(letter);

        // 计算最小长度
        int minLen = (n + 1) * (letter[25] - 1) + 1;

        // 如果有和最大长度的字母相同字母，最小长度+1
        for (int i = 24; i >= 0; i--) {
            if (letter[i] == letter[25]) {
                minLen++;
            }
        }
        // 如果计算的最小长度小于 字符串长度，则说明占位已满，取最大即可
        return Math.max(minLen, tasks.length);
    }
}