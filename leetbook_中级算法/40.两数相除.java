class Solution {
    public int divide(int dividend, int divisor) {
        // 过滤特殊值
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }

        // 确定正负号
        boolean negative = (dividend ^ divisor) < 0;
        long chu = Math.abs((long)divisor);
        long num = Math.abs((long)dividend);
        long tmp = chu;
        if (chu > num || chu == 0) {
            return 0;
        }

        // 让除数变为一个比被除数大的数，然后右移做减法：二进制除法运算
        chu = chu << 31;
        int ans = 0;
        while (tmp <= chu) {
            if (num >= chu) {
                num -= chu;
                ans = (ans << 1) + 1;
            } else {
                ans = ans << 1;
            }
            chu >>= 1;
        }
        return negative ? -ans : ans;
    }
}