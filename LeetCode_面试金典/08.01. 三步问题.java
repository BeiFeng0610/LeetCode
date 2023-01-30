class Solution {
    public int waysToStep(int n) {
        long n1 = 0, n2 = 0, n3 = 1;
        for (int i = 1; i <= n; i++) {
            long tmp = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = tmp % 1000000007;
        }
        return (int) n3;
    }
}