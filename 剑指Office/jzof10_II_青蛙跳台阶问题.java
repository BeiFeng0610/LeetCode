package 剑指Office;

class Solution {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }

        int pre = 1, cur = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (pre + cur)%1000000007;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}
