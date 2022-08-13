class Solution {
    public int titleToNumber(String columnTitle) {
        int num = 0;
        // 理解为二进制左移，这个是而十六进制左移。
        for (int i = 0; i < columnTitle.length(); i++) {
            num = num * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return num;
    }
}