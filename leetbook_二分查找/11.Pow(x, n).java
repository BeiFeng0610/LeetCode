class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
class Solution2 {
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            // 无论如何最后一次肯定不被2整除
            if(i % 2 != 0){
                res *= x;
            }
            // 次方能被2整除一次，就能用本身平方一次
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
}