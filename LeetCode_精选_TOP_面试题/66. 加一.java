import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int num = digits[i] + 1;
            carry = num >= 10 ? 1 : 0;
            digits[i] = num % 10;
            if (carry == 0) {
                return digits;
            }
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}