// 👴自己的笨方法
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
        
        /*
            有效高位
                每次碰到单1是例如，1 10 100 1000，总会重置为一次
                然后重新从下标0开始统计，例如
                    1001=1000的位数 + 1的位数
                    1010=1000的位数 + 10的位数
                 
        */
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
        // 101 比 10多一位，获取多的一位是1还是0
        // 111 比 11多一位，获取多的一位是1还是0
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
