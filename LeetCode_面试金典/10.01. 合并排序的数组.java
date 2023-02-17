import java.util.Arrays;

class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int len = m + n;
        for (int i = len - 1; i >= 0; i--) {
            if (n == 0) {
                return;
            }
            if (m == 0) {
                A[i] = B[n - 1];
                n--;
            } else if (A[m - 1] > B[n - 1]) {
                A[i] = A[m - 1];
                m--;
            } else {
                A[i] = B[n - 1];
                n--;
            }
        }
    }
}