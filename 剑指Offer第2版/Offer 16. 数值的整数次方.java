class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0) {
            return 1.0;
        }
        double res = help(x, Math.abs((long) n));
        return n < 0 ? 1 / res : res;
    }

    public double help(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double res = help(x, n / 2);
        return n % 2 == 1 ? res * res * x : res * res;
    }
}

class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0f) {
            return 0.0d;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}