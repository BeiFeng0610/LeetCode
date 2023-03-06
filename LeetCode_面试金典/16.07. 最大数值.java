class Solution {
    public int maximum(int a, int b) {
        long c = a, d = b;
        double f = Math.sqrt(1.0 * (c - d) * (c - d));
        return (int) ((f + c + d) / 2);
    }
}
class Solution {
    public int maximum(int a, int b) {
        long c = (long) a - (long) b;
        int k = (int) (c >> 63);
        return (1 + k) * a - b * k;
    }
}
