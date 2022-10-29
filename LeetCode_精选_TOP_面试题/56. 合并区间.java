import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                int[] tmp = res.get(res.size() - 1);
                if (interval[0] > tmp[1]) {
                    res.add(interval);
                } else {
                    tmp[1] = Math.max(tmp[1], interval[1]);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}