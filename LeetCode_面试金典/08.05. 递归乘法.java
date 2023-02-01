class Solution {
    public int multiply(int A, int B) {
        if (B == 1) {
            return A;
        }
        return B % 2 == 0 ? multiply(A, B / 2) << 1 : (multiply(A, B / 2) << 1) + A;
    }
}