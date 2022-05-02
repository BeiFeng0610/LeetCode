class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;

        int pre0 = getMinutes(timePoints.get(0));
        int pre = pre0;
        for (int i = 1; i < timePoints.size(); i++) {
            int cur = getMinutes(timePoints.get(i));
            ans = Math.min(ans, cur - pre);
            pre = cur;
        }
        ans = Math.min(ans, pre0+1440 - pre);

        return ans;
    }


    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
