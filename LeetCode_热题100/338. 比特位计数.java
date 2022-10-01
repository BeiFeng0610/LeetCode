class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            while (num != 0) {
                num &= (num - 1);
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 例如  100  i-1=011  &之后=0
            // 例如  110  i-1=101  &之后=100，也就是少了一个bit为1的位，100前面已经计算过了。
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}