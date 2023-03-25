import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int[] q = new int[len + 1];
        for (int i = 0; i < array.length; i++) {
            q[i + 1] = q[i] + (Character.isDigit(array[i].charAt(0)) ? 1 : -1);
        }

        int begin = 0, end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= len; i++) {
            int j = map.getOrDefault(q[i], -1);
            if (j < 0) {
                map.put(q[i], i);
            } else if (i - j > end - begin) {
                begin = j;
                end = i;
            }
        }
        String[] res = new String[end - begin];
        System.arraycopy(array, begin, res, 0, res.length);
        return res;
    }
}

class Solution {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length, begin = 0, end = 0, s = n;
        int[] first = new int[n * 2 + 1];
        Arrays.fill(first, -1); // 注：去掉可以再快 1ms（需要 s 下标改从 1 开始）
        first[s] = 0; // s[0] = 0
        for (int i = 1; i <= n; ++i) {
            s += (array[i - 1].charAt(0) >> 6 & 1) * 2 - 1;
            int j = first[s];
            if (j < 0)
                first[s] = i;
            else if (i - j > end - begin) {
                begin = j;
                end = i;
            }
        }
        String[] sub = new String[end - begin];
        System.arraycopy(array, begin, sub, 0, sub.length);
        return sub;
    }
}
