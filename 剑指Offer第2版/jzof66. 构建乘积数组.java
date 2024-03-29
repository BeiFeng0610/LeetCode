package 剑指Offer第2版;

class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len==0) return new int[len];
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
