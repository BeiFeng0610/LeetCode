class Solution {
    public int getSum(int a, int b) {
        while ((a & b) != 0) {
            int t = (a & b) << 1;
            b = a ^ b;
            a = t;
        }
        return a ^ b;
    }
}