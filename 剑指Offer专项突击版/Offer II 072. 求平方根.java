class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 把根号转换为，e的1/2倍的以e为底x的对数
        int ans = (int) Math.exp(0.5 * Math.log(x));
        // 防止溢出，验证ans
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}

class Solution2 {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        // l==r也要计算，因为也可能是平方根
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            // 找到中位数，平方小于x  ans就更新
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                // 如果不满足，区间变为   l -- mid-1(mid不满足)
                r = mid - 1;
            }
        }
        return ans;
    }
}
