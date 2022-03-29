class Solution {
    public static int fib(int n) {
        if (n < 2) {
            return n == 0 ? 0 : 1;
        }

        int pre = 0, cur = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (pre + cur)%1000000007;
            pre = cur;
            cur = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib(99));
    }
}
