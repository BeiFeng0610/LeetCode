class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x != 0 || y != 0) {
            int bit = (x & 1) ^ (y & 1);
            if (bit == 1) {
                res++;
            }
            x >>= 1;
            y >>= 1;
        }
        return res;
    }
}

class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int num = x ^ y;
        while (num > 0) {
            res += num & 1;
            num >>= 1;
        }
        return res;
    }
}

class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int num = x ^ y;
        while (num > 0) {
            num &= num - 1;
            res++;
        }
        return res;
    }
}
