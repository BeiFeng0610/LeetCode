class Solution {
    public int reverseBits(int num) {
        int max = 0, reverse = 0, current = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                current++;
                reverse++;
            } else {
                reverse = current + 1;
                current = 0;
            }
            max = Math.max(max, reverse);
            num >>= 1;
        }
        return max;
    }
}