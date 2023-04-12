package 剑指Offer第2版;

class Solution {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        int i = 1, sign = 1, res = 0, b = Integer.MAX_VALUE / 10;

        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }

        for (; i < c.length; i++) {
            if (!(c[i] >= '0' && c[i] <= '9')) {
                break;
            }
            if (res > b || res == b && c[i] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res *10 + (c[i] - '0');
        }

        return res * sign;
    }
}
