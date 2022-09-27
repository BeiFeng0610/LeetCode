class Solution {
    public int numSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkFour(n)) {
            return 4;
        }
        // n = a^2 + b^2
        for (int i = 1; i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    private boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // x == 4^k(8m + 7)
    private boolean checkFour(int x){
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
}


class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
