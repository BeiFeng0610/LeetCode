class Solution {
    public int[] countBits(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int j = i; j > 0;) {
                if ((j & 1) == 1) {
                    tmp++;
                }
                j >>= 1;
            }
            ints[i] = tmp;
        }
        return ints;
    }
}

class Solution2 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}
//1 10 11 100 101 110 111 1000 1001 1010 1011 1100 1101
class Solution3 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
