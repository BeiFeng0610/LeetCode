class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max((merged.get(merged.size() - 1)[1]), r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
