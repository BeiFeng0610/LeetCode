class Solution {
    public int exchangeBits(int num) {
        int s1 = 0x55555555;
        int s2 = 0xAAAAAAAA;
        int r = num & s1;
        int l = num & s2;
        return (l >> 1) | (r << 1);
    }
}