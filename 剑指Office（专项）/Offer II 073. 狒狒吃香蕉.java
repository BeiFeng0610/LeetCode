class Solution {
    int[] piles;

    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        int max = 0;
        for (int p : piles) {
            max = Math.max(p, max);
        }
        int l = 1, r = max;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (getHour(mid) > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


    private int getHour(int speed){
        int hour = 0;
        for (int p : piles) {
            hour += (p + speed - 1) / speed;
        }
        return hour;
    }
}
