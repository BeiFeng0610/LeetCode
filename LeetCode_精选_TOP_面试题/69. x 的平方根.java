class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int m = (int) Math.exp(0.5 * Math.log(x));
        return (long)(m + 1) * (m + 1) <= x ? m + 1 : m;
    }
}


class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if ((long) mid * mid <= x) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}


