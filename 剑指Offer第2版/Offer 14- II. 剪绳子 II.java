class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long res = 1, x = 3;
        for (int i = n / 3 - 1; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res = res * x % p;
            }
            x = x * x % p;
        }
        if (b == 0) {
            return (int) (res * 3 % p);
        }
        if (b == 1) {
            return (int) (res * 4 % p);
        }
        return (int) (res * 6 % p);
    }
}