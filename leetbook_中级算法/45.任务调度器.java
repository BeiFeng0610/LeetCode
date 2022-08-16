import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();

        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                maxCount++;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char ch : tasks) {
            count[ch - 'A']++;
        }
        Arrays.sort(count);
        int max = count[25];
        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (max == count[i]) {
                maxCount++;
            } else {
                break;
            }
        }

        // return (n + 1) * (max - 1) + maxCount <= tasks.length ? tasks.length : (n + 1) * (max - 1) + maxCount;
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }
}