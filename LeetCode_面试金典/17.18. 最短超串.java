import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> map = new HashMap<>(small.length);
        for (int num : small) {
            map.put(num, 0);
        }
        int len = big.length;
        int left = 0, right = 0, start = 0;
        int min = len;
        int find = 0;
        while (right < len) {
            int r = big[right];
            Integer count = map.get(r);
            if (count == null) {
                right++;
                continue;
            }
            if (find == 0) {
                left = right;
            }
            if (count == 0) {
                find++;
            }
            map.put(r, count + 1);
            while (find == map.size()) {
                int l = big[left];
                Integer cl = map.get(l);
                if (cl == null) {
                    left++;
                    continue;
                }
                int cnt = cl - 1;
                if (cnt == 0) {
                    if (right - left < min) {
                        start = left;
                        min = right - left;
                    }
                    find--;
                }
                map.put(l, cnt);
                left++;
            }
            right++;
        }
        return min == len ? new int[0] : new int[]{start, start + min};
    }
}