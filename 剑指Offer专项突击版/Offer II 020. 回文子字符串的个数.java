class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        // 中心扩展，中心个数位2*n-1个，例如 abc，中心位为a ab b bc c，因为回文串字母个数可能为偶数位，则中心位为两位。
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
