class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            // 防止溢出
            long tmp = (long) mid * mid;
            if (tmp == num) {
                return true;
            } else if (tmp < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}