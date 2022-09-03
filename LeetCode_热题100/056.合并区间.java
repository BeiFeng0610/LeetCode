import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        // 按照左数排序
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        int len = intervals.length;

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            // 获取集合中末尾元素
            int[] ints = list.get(list.size() - 1);
            if (ints[1] >= intervals[i][0]) {
                ints[1] = Math.max(ints[1], intervals[i][1]);
                list.set(list.size() - 1, ints);
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        int len = intervals.length;

        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int leftNum = interval[0], rightNum = interval[1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < leftNum) {
                list.add(new int[]{leftNum, rightNum});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], rightNum);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
