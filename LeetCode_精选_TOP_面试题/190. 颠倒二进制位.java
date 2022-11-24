public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }
}

public class Solution {

    public static final int B1 = 0x55555555;
    public static final int B2 = 0x33333333;
    public static final int B4 = 0x0f0f0f0f;
    public static final int B8 = 0x00ff00ff;

    public int reverseBits(int n) {
        n = n >>> 1 & B1 | (n & B1) << 1;
        n = n >>> 2 & B2 | (n & B2) << 2;
        n = n >>> 4 & B4 | (n & B4) << 4;
        n = n >>> 8 & B8 | (n & B8) << 8;
        return n >>> 16 | n << 16;
    }
}
