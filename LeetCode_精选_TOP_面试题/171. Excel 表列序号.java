class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int wei = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            res += wei * (columnTitle.charAt(i) - 'A' + 1);
            wei *= 26;
        }
        return res;
    }
}