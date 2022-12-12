import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        Arrays.fill(res, n);
        for (int i = 1; i <= n; i++) {
            double m = Math.sqrt(i);
            if (m == (int) m) {
                set.add(i);
                res[i] = 1;
            } else {
                for (int j : set) {
                    res[i] = Math.min(res[i], res[i - j] + 1);
                }
            }
        }
        return res[n];
    }
}

class Solution {
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, res[i - j * j]);
            }
            res[i] = min + 1;
        }
        return res[n];
    }
}

class Solution {
    public int numSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkFour(n)) {
            return 4;
        }
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








