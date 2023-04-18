class Solution {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int pre = 1, cur = 2, res = 0;
        for (int i = 2; i < n; i++) {
            res = (pre + cur) % 1000000007;
            pre = cur;
            cur = res;
        }
        return res;
    }
}