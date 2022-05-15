class Solution {
    int[] piles;

    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        int max = 0;
        // 求最大的香蕉堆
        for (int p : piles) {
            max = Math.max(p, max);
        }
        // 最大堆为，最大速度
        int l = 1, r = max;
        while (l < r) {
            // 求中间速度，然后对比所需时间
            int mid = (r - l) / 2 + l;
            if (getHour(mid) > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // 传入速度，计算所需时间
    private int getHour(int speed){
        int hour = 0;
        for (int p : piles) {
            hour += (p + speed - 1) / speed;
        }
        return hour;
    }
}
