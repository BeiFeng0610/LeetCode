class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) {
            return intervals;
        }
        // 把数组按照第一位数排序，保证左边界最小的在第一位
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            // 获取当前数组的左右边界
            int l = intervals[i][0], r = intervals[i][1];
            // 判断集合为0，则直接新增，或者前一个区间，右边界小于当前左边界，则添加新的区间
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                // 设置右边界，去当前右边界和前一个区间右边界的最大值，更新前一个区间
                merged.get(merged.size() - 1)[1] = Math.max((merged.get(merged.size() - 1)[1]), r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
