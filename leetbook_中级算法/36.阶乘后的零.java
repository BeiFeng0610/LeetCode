class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        // 尾数有多少0主要看  阶乘中质因子有多少个 10 或者找有多少对 【2 5】
        // 5出现的频率显然比 2 少，所以只用找 5 出现的次数即可
        // 10 拆分成 2*5 15拆分成 5*3，这其中的5都算
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }
}