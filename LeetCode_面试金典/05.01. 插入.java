class Solution {
    public int insertBits(int N, int M, int i, int j) {
        long low = N & ((1L << i) - 1);
        long mid = N & ((1L << (j + 1)) - 1) ^ low;
        return (int) (N ^ mid ^ (M << i));
    }
}

class Solution {
    public int insertBits(int N, int M, int i, int j) {
        int bit = ((1 << (j - i + 1)) - 1) << i;
        return N & (~bit) ^ (M << i);
    }
}