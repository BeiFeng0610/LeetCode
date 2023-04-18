class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int pre = 1, cur = 1, res = 1;
        for (int i = 2; i < n; i++) {
            res = (cur + pre) % 1000000007;
            pre = cur;
            cur = res;
        }
        return res;
    }
}