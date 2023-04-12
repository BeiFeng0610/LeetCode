class Solution {
    public int findMinDifference(List<String> timePoints) {
        // 鸽巢原理，因为一天最多1440分钟，所有最多出现1440种情况，如果超过，必有重复项，则返回0即可
        if (timePoints.size() > 1440) {
            return 0;
        }
        // 排序集合
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        // 第一个时间的总分钟数
        int pre0 = getMinutes(timePoints.get(0));
        // 前一个时间的总分钟数
        int pre = pre0;
        for (int i = 1; i < timePoints.size(); i++) {
            // 当前时间的总分钟数
            int cur = getMinutes(timePoints.get(i));
            // 更新最小时间间隔
            ans = Math.min(ans, cur - pre);
            pre = cur;
        }
        // 用第一个时间减去最后一个时间，更新最小时间差
        ans = Math.min(ans, pre0+1440 - pre);
        return ans;
    }

    // 计算总分钟数
    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
