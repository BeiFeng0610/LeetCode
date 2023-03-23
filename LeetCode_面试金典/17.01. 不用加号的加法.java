class Solution {
    public int add(int a, int b) {
        int s = 0, j = 0;
        while (b != 0) {
            s = a ^ b;
            j = (a & b) << 1;
            a = s;
            b = j;
        }
        return s;
    }
}