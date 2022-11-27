class Solution {
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int tag = 0;
        for (int i = n; i > 0; i--) {
            tag = tag + i;
            if (sum == tag) {
                return i;
            }
            sum = sum - i;
        }
        return -1;
    }
}